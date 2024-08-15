import SwiftUI
import WanderWise

@main
struct kmpSampleApp: App {
  @UIApplicationDelegateAdaptor var delegate: AppDelegate
  @Environment(\.scenePhase)  var scenePhase: ScenePhase

  var defaultRouterContext: RouterContext { delegate.holder.defaultRouterContext }

  var body: some Scene {
    WindowGroup {
      ComposeView(routerContext: defaultRouterContext)
    }
    .onChange(of: scenePhase) { newPhase in
        switch newPhase {
        case .background: defaultRouterContext.stop()
        case .inactive: defaultRouterContext.pause()
        case .active: defaultRouterContext.resume()
        @unknown default: break
        }
    }
  }
}

class DefaultRouterHolder : ObservableObject {
  let defaultRouterContext: RouterContext = DefaultRouterContextKt.defaultRouterContext()

  deinit {
    // Destroy the root component before it is deallocated
    defaultRouterContext.destroy()
  }
}

class AppDelegate: NSObject, UIApplicationDelegate {
    let holder: DefaultRouterHolder = DefaultRouterHolder()
}

struct ComposeView: UIViewControllerRepresentable {
  let routerContext: RouterContext

  func makeUIViewController(context: Context) -> UIViewController {
    return SampleAppViewControllerKt.createViewController(routerContext: routerContext)
  }

  func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}
