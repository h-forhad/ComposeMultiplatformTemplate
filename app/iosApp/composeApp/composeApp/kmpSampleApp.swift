import SwiftUI
import Favily

@main
struct kmpSampleApp: App {
  @UIApplicationDelegateAdaptor var delegate: AppDelegate
  @Environment(\.scenePhase)  var scenePhase: ScenePhase

  var defaultRouterContext: RouterContext { delegate.holder.defaultRouterContext }

  var body: some Scene {
    WindowGroup {
      ComposeView(routerContext: defaultRouterContext).ignoresSafeArea()
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
    let controller = SampleAppViewControllerKt.createViewController(routerContext: routerContext)
      setupStatusBar(view: controller.view)
    return controller
  }

  func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
    
    private func setupStatusBar(view: UIView) {
        let statusBarColor = UIColor(red: 112/255.0, green: 210/255.0, blue: 255/255.0, alpha: 1.0)
         let statusbarView = UIApplication.shared.statusBarUIView
         statusbarView?.backgroundColor = statusBarColor
     }
}

extension UIApplication {
var statusBarUIView: UIView? {
    if #available(iOS 13.0, *) {
        let tag = 38482
        let keyWindow = UIApplication.shared.windows.filter {$0.isKeyWindow}.first

        if let statusBar = keyWindow?.viewWithTag(tag) {
            return statusBar
        } else {
            guard let statusBarFrame = keyWindow?.windowScene?.statusBarManager?.statusBarFrame else { return nil }
            let statusBarView = UIView(frame: statusBarFrame)
            statusBarView.tag = tag
            keyWindow?.addSubview(statusBarView)
            return statusBarView
        }
    } else if responds(to: Selector(("statusBar"))) {
        return value(forKey: "statusBar") as? UIView
    } else {
        return nil
    }
  }
}
