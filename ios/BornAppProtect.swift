@objc(BornAppProtect)
class BornAppProtect: NSObject {

  private var previousMirroringStatus: Bool = false

  @objc func isScreenMirroringEnabled() -> Bool {
    // It will cover screen mirroring, screen recording or AirPlay
    if UIScreen.main.isCaptured {
      // Screen is currently being captured, which indicates screen mirroring
      return true
    } else {
      return false
    }
  }

  @objc(startScreenMirroringStatusPolling:withResolver:withRejecter:)
  func startScreenMirroringStatusPolling(_ interval: TimeInterval, withResolver resolve: @escaping RCTPromiseResolveBlock, withRejecter reject: @escaping RCTPromiseRejectBlock) -> Void {
    DispatchQueue.main.async {
      _ = Timer.scheduledTimer(withTimeInterval: interval, repeats: true) { timer in
        let isMirroringEnabled = self.isScreenMirroringEnabled()
        if isMirroringEnabled != self.previousMirroringStatus {
          self.previousMirroringStatus = isMirroringEnabled
          resolve(isMirroringEnabled)
          timer.invalidate() // Stop the timer after the first invocation
        }
      }
    }
  }

  @objc(multiply:withB:withResolver:withRejecter:)
  func multiply(a: Float, b: Float, resolve:RCTPromiseResolveBlock,reject:RCTPromiseRejectBlock) -> Void {
    resolve(a*b)
  }
}
