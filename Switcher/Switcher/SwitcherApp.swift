//
//  SwitcherApp.swift
//  Switcher
//
//  Created by sjh354 on 6/13/26.
//

import SwiftUI

@main
struct SwitcherApp: App {
    var body: some Scene {
        WindowGroup {
            NavigationStack {
                DeviceListView()
            }
        }
    }
}
