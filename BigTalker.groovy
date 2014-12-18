/**
 *  Big Talker  -- Version 1.0.1
 *  Copyright 2014 brian@rayzurbock.com
 *  For the latest version and test releases visit http://www.github.com/rayzurbock
 *  Donations accepted via Paypal, but not required - rayzur@rayzurbock.com
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 * 
 */
definition(
    name: "Big Talker",
    namespace: "rayzurbock",
    author: "brian@rayzurbock.com",
    description: "Let's talk about mode changes, switches, motions, and so on.",
    category: "Fun & Social",
    iconUrl: "http://rayzurbock.com/ST/icons/BigTalker.png",
    iconX2Url: "http://rayzurbock.com/ST/icons/BigTalker@2x.png",
    iconX3Url: "http://rayzurbock.com/ST/icons/BigTalker@2x.png")


preferences {
    page(name: "pageStart")
    page(name: "pageStatus")
    page(name: "pageConfigure")
    page(name: "pageConfigMotion")
    page(name: "pageConfigSwitch")
    page(name: "pageConfigPresence")
    page(name: "pageConfigLock")
    page(name: "pageConfigContact")
    page(name: "pageConfigMode")
    page(name: "pageConfigThermostat")
//End preferences
}

def pageStart(){
    dynamicPage(name: "pageStart", title: "Big Talker"){
        section(){
            href "pageStatus", title:"Status", description:"Tap to view status"
            href "pageConfigure", title:"Configure", description:"Tap to configure"
        }
        section(){
            paragraph "Big Talker is a SmartApp that can make your house talk depending on various triggered events."
            paragraph "Pair with any SmartThings compatible speech synthesis audio device such as Sonos, VLC Thing on your computer or Raspberry Pi!\n"
        }
        section(){
            if (!(state.appversion == null)){ 
                paragraph "Big Talker ${state.appversion}\nhttp://www.github.com/rayzurbock\n" 
            } else {
                paragraph "Big Talker \nhttp://www.github.com/rayzurbock\n" 
            }
        }
    }
}

def pageStatus(){
    //dynamicPage(name: "pageStatus", title: "Big Talker is configured as follows:", nextPage: "pageConfigure"){
    dynamicPage(name: "pageStatus", title: "Big Talker is configured as follows:"){
        String enabledDevices = ""
  
        //BEGIN STATUS CONFIG MOTION GROUP 1
        if (settings.motionDeviceGroup1) {
            enabledDevices += "Devices:  \n"
            settings.motionDeviceGroup1.each() {
                enabledDevices += "${it.displayName},"
            }
            enabledDevices += "\n\n"
            if (settings.motionTalkActive1) {
                enabledDevices += "Say on active:\n ${settings.motionTalkActive1}\n"
            }
            if (settings.motionTalkInactive1) {
                enabledDevices += "Say on inactive:\n ${settings.motionTalkInactive1}\n"
            }
            if (settings.motionSpeechDevice1) {
                enabledDevices += "Custom Speech Device(s):\n"
                settings.motionSpeechDevice1.each() {
                    enabledDevices += "Speech Device(s): ${it.displayName}\n"
                }
            }
            if (!(enabledDevices == "")) {
                section ("Motion Sensor Group 1:"){
                    paragraph enabledDevices
                }
            }
            enabledDevices = ""
        }
        //END STATUS CONFIG MOTION GROUP 1
        //BEGIN STATUS CONFIG MOTION GROUP 2
        if (settings.motionDeviceGroup2) {
            enabledDevices += "Devices:  \n"
            settings.motionDeviceGroup2.each() {
                enabledDevices += "${it.displayName},"
            }
            enabledDevices += "\n\n"
            if (settings.motionTalkActive2) {
                enabledDevices += "Say on active:\n ${settings.motionTalkActive2}\n"
            }
            if (settings.motionTalkInactive2) {
                enabledDevices += "Say on inactive:\n ${settings.motionTalkInactive2}\n"
            }
            if (settings.motionSpeechDevice2) {
                enabledDevices += "Custom Speech Device(s):\n"
                settings.motionSpeechDevice2.each() {
                    enabledDevices += "Speech Device(s): ${it.displayName}\n"
                }
            }
            if (!(enabledDevices == "")) {
                section ("Motion Sensor Group 2:"){
                    paragraph enabledDevices
                }
            }
            enabledDevices = ""
        }
        //END STATUS CONFIG MOTION GROUP 1
        //BEGIN STATUS CONFIG MOTION GROUP 3
        if (settings.motionDeviceGroup3) {
            enabledDevices += "Devices:  \n"
            settings.motionDeviceGroup3.each() {
                enabledDevices += "${it.displayName},"
            }
            enabledDevices += "\n\n"
            if (settings.motionTalkActive3) {
                enabledDevices += "Say on active:\n ${settings.motionTalkActive3}\n"
            }
            if (settings.motionTalkInactive3) {
                enabledDevices += "Say on inactive:\n ${settings.motionTalkInactive3}\n"
            }
            if (settings.motionSpeechDevice3) {
                enabledDevices += "Custom Speech Device(s):\n"
                settings.motionSpeechDevice3.each() {
                    enabledDevices += "Speech Device(s): ${it.displayName}\n"
                }
            }
            if (!(enabledDevices == "")) {
                section ("Motion Sensor Group 3:"){
                    paragraph enabledDevices
                }
            }
            enabledDevices = ""
        }
        //END STATUS CONFIG MOTION GROUP 3
        
        //BEGIN STATUS CONFIG SWITCH GROUP 1
        if (settings.switchDeviceGroup1) {
            enabledDevices += "Devices:  \n"
            settings.switchDeviceGroup1.each() {
                enabledDevices += "${it.displayName},"
            }
            enabledDevices += "\n\n"
            if (settings.switchTalkOn1) {
                enabledDevices += "Say when switched ON:\n ${settings.switchTalkOn1}\n"
            }
            if (settings.switchTalkOff1) {
                enabledDevices += "Say when switched OFF:\n ${settings.switchTalkOff1}\n"
            }
            if (settings.switchSpeechDevice1) {
                enabledDevices += "Custom Speech Device(s):\n"
                settings.switchSpeechDevice1.each() {
                    enabledDevices += "Speech Device(s): ${it.displayName}\n"
                }
            }
            if (!(enabledDevices == "")) {
                section ("Switch Group 1:"){
                    paragraph enabledDevices
                }
            }
            enabledDevices = ""
        }
        //END STATUS CONFIG SWITCH GROUP 1
        //BEGIN STATUS CONFIG SWITCH GROUP 2
        if (settings.switchDeviceGroup2) {
            enabledDevices += "Devices:  \n"
            settings.switchDeviceGroup2.each() {
                enabledDevices += "${it.displayName},"
            }
            enabledDevices += "\n\n"
            if (settings.switchTalkOn2) {
                enabledDevices += "Say when switched ON:\n ${settings.switchTalkOn2}\n"
            }
            if (settings.switchTalkOff2) {
                enabledDevices += "Say when switched OFF:\n ${settings.switchTalkOff2}\n"
            }
            if (settings.switchSpeechDevice2) {
                enabledDevices += "Custom Speech Device(s):\n"
                settings.switchSpeechDevice2.each() {
                    enabledDevices += "Speech Device(s): ${it.displayName}\n"
                }
            }
            if (!(enabledDevices == "")) {
                section ("Switch Group 2:"){
                    paragraph enabledDevices
                }
            }
            enabledDevices = ""
        }
        //END STATUS CONFIG SWITCH GROUP 2
        //BEGIN STATUS CONFIG SWITCH GROUP 3
        if (settings.switchDeviceGroup3) {
            enabledDevices += "Devices:  \n"
            settings.switchDeviceGroup3.each() {
                enabledDevices += "${it.displayName},"
            }
            enabledDevices += "\n\n"
            if (settings.switchTalkOn3) {
                enabledDevices += "Say when switched ON:\n ${settings.switchTalkOn3}\n"
            }
            if (settings.switchTalkOff3) {
                enabledDevices += "Say when switched OFF:\n ${settings.switchTalkOff3}\n"
            }
            if (settings.switchSpeechDevice3) {
                enabledDevices += "Custom Speech Device(s):\n"
                settings.switchSpeechDevice3.each() {
                    enabledDevices += "Speech Device(s): ${it.displayName}\n"
                }
            }
            if (!(enabledDevices == "")) {
                section ("Switch Group 3:"){
                    paragraph enabledDevices
                }
            }
            enabledDevices = ""
        }
        //END STATUS CONFIG SWITCH GROUP 1
        
        //BEGIN STATUS CONFIG PRESENCE GROUP 1
        if (settings.presDeviceGroup1) {
            enabledDevices += "Devices:  \n"
            settings.presDeviceGroup1.each() {
                enabledDevices += "${it.displayName},"
            }
            enabledDevices += "\n\n"
            if (settings.presTalkOnArrive1) {
                enabledDevices += "Say on arrive:\n ${settings.presTalkOnArrive1}\n"
            }
            if (settings.presTalkOnLeave1) {
                enabledDevices += "Say on leave:\n ${settings.presTalkOnLeave1}\n"
            }
            if (settings.presSpeechDevice1) {
                enabledDevices += "Custom Speech Device(s):\n"
                settings.presSpeechDevice1.each() {
                    enabledDevices += "Speech Device: ${it.displayName}\n"
                }
            }
            if (!(enabledDevices == "")) {
                section ("Presence Group 1:"){
                    paragraph enabledDevices
                }
            }
            enabledDevices = ""
        }
        //END STATUS CONFIG PRESENCE GROUP 1
        //BEGIN STATUS CONFIG PRESENCE GROUP 2
        if (settings.presDeviceGroup2) {
            enabledDevices += "Devices:  \n"
            settings.presDeviceGroup2.each() {
                enabledDevices += "${it.displayName},"
            }
            enabledDevices += "\n\n"
            if (settings.presTalkOnArrive2) {
                enabledDevices += "Say on arrive:\n ${settings.presTalkOnArrive2}\n"
            }
            if (settings.presTalkOnLeave2) {
                enabledDevices += "Say on leave:\n ${settings.presTalkOnLeave2}\n"
            }
            if (settings.presSpeechDevice2) {
                enabledDevices += "Custom Speech Device(s):\n"
                settings.presSpeechDevice2.each() {
                    enabledDevices += "Speech Device: ${it.displayName}\n"
                }
            }
            if (!(enabledDevices == "")) {
                section ("Presence Group 2:"){
                    paragraph enabledDevices
                }
            }
            enabledDevices = ""
        }
        //END STATUS CONFIG PRESENCE GROUP 2
        //BEGIN STATUS CONFIG PRESENCE GROUP 3
        if (settings.presDeviceGroup3) {
            enabledDevices += "Devices:  \n"
            settings.presDeviceGroup3.each() {
                enabledDevices += "${it.displayName},"
            }
            enabledDevices += "\n\n"
            if (settings.presTalkOnArrive3) {
                enabledDevices += "Say on arrive:\n ${settings.presTalkOnArrive3}\n"
            }
            if (settings.presTalkOnLeave3) {
                enabledDevices += "Say on leave:\n ${settings.presTalkOnLeave3}\n"
            }
            if (settings.presSpeechDevice3) {
                enabledDevices += "Custom Speech Device(s):\n"
                settings.presSpeechDevice3.each() {
                    enabledDevices += "Speech Device: ${it.displayName}\n"
                }
            }
            if (!(enabledDevices == "")) {
                section ("Presence Group 3:"){
                    paragraph enabledDevices
                }
            }
            enabledDevices = ""
        }
        //END STATUS CONFIG PRESENCE GROUP 1
        
        //BEGIN STATUS CONFIG LOCK GROUP 1
        if (settings.lockDeviceGroup1) {
            enabledDevices += "Devices:  \n"
            settings.lockDeviceGroup1.each() {
                enabledDevices += "${it.displayName},"
            }
            enabledDevices += "\n\n"
            if (settings.lockTalkOnLock1) {
                enabledDevices += "Say when locked:\n ${settings.lockTalkOnLock1}\n"
            }
            if (settings.lockTalkOnUnlock1) {
                enabledDevices += "Say when unlocked:\n ${settings.lockTalkOnUnlock1}\n"
            }
            if (settings.lockSpeechDevice1) {
                enabledDevices += "Custom Speech Device(s):\n"
                settings.lockSpeechDevice1.each() {
                    enabledDevices += "Speech Device(s): ${it.displayName}\n"
                }
            }
            if (!(enabledDevices == "")) {
                section ("Lock Group 1:"){
                    paragraph enabledDevices
                }
            }
            enabledDevices = ""
        }
        //END STATUS CONFIG LOCK GROUP 1
        //BEGIN STATUS CONFIG LOCK GROUP 2
        if (settings.lockDeviceGroup2) {
            enabledDevices += "Devices:  \n"
            settings.lockDeviceGroup2.each() {
                enabledDevices += "${it.displayName},"
            }
            enabledDevices += "\n\n"
            if (settings.lockTalkOnLock2) {
                enabledDevices += "Say when locked:\n ${settings.lockTalkOnLock2}\n"
            }
            if (settings.lockTalkOnUnlock2) {
                enabledDevices += "Say when unlocked:\n ${settings.lockTalkOnUnlock2}\n"
            }
            if (settings.lockSpeechDevice2) {
                enabledDevices += "Custom Speech Device(s):\n"
                settings.lockSpeechDevice2.each() {
                    enabledDevices += "Speech Device(s): ${it.displayName}\n"
                }
            }
            if (!(enabledDevices == "")) {
                section ("Lock Group 2:"){
                    paragraph enabledDevices
                }
            }
            enabledDevices = ""
        }
        //END STATUS CONFIG LOCK GROUP 2
        //BEGIN STATUS CONFIG LOCK GROUP 3
        if (settings.lockDeviceGroup3) {
            enabledDevices += "Devices:  \n"
            settings.lockDeviceGroup3.each() {
                enabledDevices += "${it.displayName},"
            }
            enabledDevices += "\n\n"
            if (settings.lockTalkOnLock3) {
                enabledDevices += "Say when locked:\n ${settings.lockTalkOnLock3}\n"
            }
            if (settings.lockTalkOnUnlock3) {
                enabledDevices += "Say when unlocked:\n ${settings.lockTalkOnUnlock3}\n"
            }
            if (settings.lockSpeechDevice3) {
                enabledDevices += "Custom Speech Device(s):\n"
                settings.lockSpeechDevice3.each() {
                    enabledDevices += "Speech Device(s): ${it.displayName}\n"
                }
            }
            if (!(enabledDevices == "")) {
                section ("Lock Group 3:"){
                    paragraph enabledDevices
                }
            }
            enabledDevices = ""
        }
        //END STATUS CONFIG LOCK GROUP 3
        
        //BEGIN STATUS CONFIG CONTACT GROUP 1
        if (settings.contactDeviceGroup1) {
            enabledDevices += "Devices:  \n"
            settings.contactDeviceGroup1.each() {
                enabledDevices += "${it.displayName},"
            }
            enabledDevices += "\n\n"
            if (settings.contactTalkOnOpen1) {
                enabledDevices += "Say when opened:\n ${settings.contactTalkOnOpen1}\n"
            }
            if (settings.contactTalkOnClose1) {
                enabledDevices += "Say when closed:\n ${settings.contactTalkOnClose1}\n"
            }
            if (settings.contactSpeechDevice1) {
                enabledDevices += "Custom Speech Device(s):\n"
                settings.contactSpeechDevice1.each() {
                    enabledDevices += "Speech Device(s): ${it.displayName}\n"
                }
            }
            if (!(enabledDevices == "")) {
                section ("Contact Group 1:"){
                    paragraph enabledDevices
                }
            }
            enabledDevices = ""
        }
        //END STATUS CONFIG CONTACT GROUP 1
        //BEGIN STATUS CONFIG CONTACT GROUP 2
        if (settings.contactDeviceGroup2) {
            enabledDevices += "Devices:  \n"
            settings.contactDeviceGroup2.each() {
                enabledDevices += "${it.displayName},"
            }
            enabledDevices += "\n\n"
            if (settings.contactTalkOnOpen2) {
                enabledDevices += "Say when opened:\n ${settings.contactTalkOnOpen2}\n"
            }
            if (settings.contactTalkOnClose2) {
                enabledDevices += "Say when closed:\n ${settings.contactTalkOnClose2}\n"
            }
            if (settings.contactSpeechDevice2) {
                enabledDevices += "Custom Speech Device(s):\n"
                settings.contactSpeechDevice2.each() {
                    enabledDevices += "Speech Device(s): ${it.displayName}\n"
                }
            }
            if (!(enabledDevices == "")) {
                section ("Contact Group 2:"){
                    paragraph enabledDevices
                }
            }
            enabledDevices = ""
        }
        //END STATUS CONFIG CONTACT GROUP 2
        //BEGIN STATUS CONFIG CONTACT GROUP 3
        if (settings.contactDeviceGroup3) {
            enabledDevices += "Devices:  \n"
            settings.contactDeviceGroup3.each() {
                enabledDevices += "${it.displayName},"
            }
            enabledDevices += "\n\n"
            if (settings.contactTalkOnOpen3) {
                enabledDevices += "Say when opened:\n ${settings.contactTalkOnOpen3}\n"
            }
            if (settings.contactTalkOnClose3) {
                enabledDevices += "Say when closed:\n ${settings.contactTalkOnClose3}\n"
            }
            if (settings.contactSpeechDevice3) {
                enabledDevices += "Custom Speech Device(s):\n"
                settings.contactSpeechDevice3.each() {
                    enabledDevices += "Speech Device(s): ${it.displayName}\n"
                }
            }
            if (!(enabledDevices == "")) {
                section ("Contact Group 3:"){
                    paragraph enabledDevices
                }
            }
            enabledDevices = ""
        }
        //END STATUS CONFIG CONTACT GROUP 3
        
        //BEGIN STATUS CONFIG MODE CHANGE GROUP 1
        if (settings.modePhraseGroup1) {
            enabledDevices += "Modes:  \n"
            settings.modePhraseGroup1.each() {
                enabledDevices += "${it},"
            }
            enabledDevices += "\n\n"
            if (settings.contactTalkOnOpen1) {
                enabledDevices += "Say when changed:\n ${settings.TalkOnModeChange1}\n"
            }
            if (settings.modeSpeechDevice1) {
                enabledDevices += "Custom Speech Device(s):\n"
                settings.contactSpeechDevice1.each() {
                    enabledDevices += "Speech Device(s): ${it.displayName}\n"
                }
            }
            if (!(enabledDevices == "")) {
                section ("Mode Change:"){
                    paragraph enabledDevices
                }
            }
            enabledDevices = ""
        }
        //END STATUS CONFIG MODE CHANGE GROUP 1
        
        //BEGIN STATUS CONFIG THERMOSTAT GROUP 1
        if (settings.thermostatDeviceGroup1) {
            enabledDevices += "Devices:  \n"
            settings.thermostatDeviceGroup1.each() {
                enabledDevices += "${it.displayName},"
            }
            enabledDevices += "\n\n"
            if (settings.thermostatTalkOnIdle1) {
                enabledDevices += "Say when Idle:\n ${settings.thermostatTalkOnIdle1}\n"
            }
            if (settings.thermostatTalkOnHeating1) {
                enabledDevices += "Say when Heating:\n ${settings.thermostatTalkOnHeating1}\n"
            }
            if (settings.thermostatTalkOnCooling1) {
                enabledDevices += "Say when Cooling:\n ${settings.thermostatTalkOnCooling1}\n"
            }
            if (settings.thermostatTalkOnFan1) {
                enabledDevices += "Say when Fan:\n ${settings.thermostatTalkOnFan1}\n"
            }
            if (settings.thermostatSpeechDevice1) {
                enabledDevices += "Custom Speech Device(s):\n"
                settings.contactSpeechDevice1.each() {
                    enabledDevices += "Speech Device(s): ${it.displayName}\n"
                }
            }
            if (!(enabledDevices == "")) {
                section ("Thermostat Group 1:"){
                    paragraph enabledDevices
                }
            }
            enabledDevices = ""
        }
        //END STATUS CONFIG THERMOSTAT GROUP 1
    }
}

def pageConfigure(){
    if (state.installed == null) { state.installed = false }
    dynamicPage(name: "pageConfigure", title: "Configure", install: true, uninstall: state.installed) {
        section ("Talk with:"){
            //input "speechDeviceDefault", "capability.speechSynthesis", title: "Talk with these text-to-speech devices (default)", multiple: true, required: false, refreshAfterSelection: true
            input "speechDeviceDefault", "capability.musicPlayer", title: "Talk with these text-to-speech devices (default)", multiple: true, required: true, refreshAfterSelection: true
        }
        section("Talk on events:") {
            href "pageConfigMotion", title:"Motion", description:"Tap to configure"
            href "pageConfigSwitch", title:"Switch", description:"Tap to configure"
            href "pageConfigPresence", title:"Presence", description:"Tap to configure"
            href "pageConfigLock", title:"Lock", description:"Tap to configure"
            href "pageConfigContact", title:"Contact", description:"Tap to configure"
            href "pageConfigMode", title:"Mode", description:"Tap to configure"
            href "pageConfigThermostat", title:"Thermostat", description:"Tap to configure"
        }
//        section([mobileOnly:true]){
//            label title: "SmartApp Name (Front Door Left Open)", required: true
//            mode title: "Set for specific mode(s)", required: false
//        }
    }
//End pageConfigure()
}

def pageConfigMotion(){
    dynamicPage(name: "pageConfigMotion", title: "Configure talk on motion", install: false, uninstall: false) {
        section("Motion Sensor Group 1"){
            input "motionDeviceGroup1", "capability.motionSensor", title: "Motion Sensor(s)", required: false, multiple: true
            input "motionTalkActive1", "text", title: "Say this on motion active:", required: false, defaultValue: "%devicename% is now %devicechange%"
            input "motionTalkInactive1", "text", title: "Say this on motion inactive:", required: false, defaultValue: "%devicename% is now %devicechange%"
            input "motionSpeechDevice1", "capability.speechSynthesis", title: "Talk with these text-to-speech devices (overrides default)", multiple: true, required: false
        }
        section("Motion Sensor Group 2"){
            input "motionDeviceGroup2", "capability.motionSensor", title: "Motion Sensor(s)", required: false, multiple: true
            input "motionTalkActive2", "text", title: "Say this on motion active:", required: false
            input "motionTalkInactive2", "text", title: "Say this on motion inactive:", required: false
            input "motionSpeechDevice2", "capability.speechSynthesis", title: "Talk with these text-to-speech devices (overrides default)", multiple: true, required: false
        }
        section("Motion Sensor Group 3"){
            input "motionDeviceGroup3", "capability.motionSensor", title: "Motion Sensor(s)", required: false, multiple: true
            input "motionTalkActive3", "text", title: "Say this on motion active:", required: false
            input "motionTalkInactive3", "text", title: "Say this on motion inactive:", required: false
            input "motionSpeechDevice3", "capability.speechSynthesis", title: "Talk with these text-to-speech devices (overrides default)", multiple: true, required: false
        }
    }
//End pageConfigMotion()
}

def pageConfigSwitch(){
    dynamicPage(name: "pageConfigSwitch", title: "Configure talk on switch", install: false, uninstall: false) {
        section("Switch Group 1"){
            input name: "switchDeviceGroup1", type: "capability.switch", title: "Switch(es)", required: false, multiple: true
            input name: "switchTalkOn1", type: "text", title: "Say this when switch is turned ON:", required: false, defaultValue: "%devicename% is now %devicechange%"
            input name: "switchTalkOff1", type: "text", title: "Say this when switch is turned OFF:", required: false, defaultValue: "%devicename% is now %devicechange%"
            input name: "switchSpeechDevice1", type: "capability.speechSynthesis", title: "Talk with these text-to-speech devices (overrides default)", multiple: true, required: false
        }
        section("Switch Group 2"){
            input name: "switchDeviceGroup2", type: "capability.switch", title: "Switch(es)", required: false, multiple: true
            input name: "switchTalkOn2", type: "text", title: "Say this when switch is turned ON:", required: false
            input name: "switchTalkOff2", type: "text", title: "Say this when switch is turned OFF:", required: false
            input name: "switchSpeechDevice2", type: "capability.speechSynthesis", title: "Talk with these text-to-speech devices (overrides default)", multiple: true, required: false
        }
        section("Switch Group 3"){
            input name: "switchDeviceGroup3", type: "capability.switch", title: "Switch(es)", required: false, multiple: true
            input name: "switchTalkOn3", type: "text", title: "Say this when switch is turned ON:", required: false
            input name: "switchTalkOff3", type: "text", title: "Say this when switch is turned OFF:", required: false
            input name: "switchSpeechDevice3", type: "capability.speechSynthesis", title: "Talk with these text-to-speech devices (overrides default)", multiple: true, required: false
        }
    }
//End pageConfigSwitch()
}

def pageConfigPresence(){
    dynamicPage(name: "pageConfigPresence", title: "Configure talk on presence", install: false, uninstall: false) {
        section("Presence Group 1"){
            input name: "presDeviceGroup1", type: "capability.presenceSensor", title: "Presence Sensor(s)", required: false, multiple: true
            input name: "presTalkOnArrive1", type: "text", title: "Say this when someone arrives:", required: false, defaultValue: "%devicename% has arrived"
            input name: "presTalkOnLeave1", type: "text", title: "Say this when someone leaves:", required: false, defaultValue: "%devicename% has left"
            input name: "presSpeechDevice1", type: "capability.speechSynthesis", title: "Talk with these text-to-speech devices (overrides default)", multiple: true, required: false
        }
        section("Presence Group 2"){
            input name: "presDeviceGroup2", type: "capability.presenceSensor", title: "Presence Sensor(s)", required: false, multiple: true
            input name: "presTalkOnArrive2", type: "text", title: "Say this when someone arrives:", required: false
            input name: "presTalkOnLeave2", type: "text", title: "Say this when someone leaves:", required: false
            input name: "presSpeechDevice2", type: "capability.speechSynthesis", title: "Talk with these text-to-speech devices (overrides default)", multiple: true, required: false
        }
        section("Presence Group 3"){
            input name: "presDeviceGroup3", type: "capability.presenceSensor", title: "Presence Sensor(s)", required: false, multiple: true
            input name: "presTalkOnArrive3", type: "text", title: "Say this when someone arrives:", required: false
            input name: "presTalkOnLeave3", type: "text", title: "Say this when someone leaves:", required: false
            input name: "presSpeechDevice3", type: "capability.speechSynthesis", title: "Talk with these text-to-speech devices (overrides default)", multiple: true, required: false
        }
    }
//End pageConfigPresence()
}

def pageConfigLock(){
    dynamicPage(name: "pageConfigLock", title: "Configure talk on lock", install: false, uninstall: false) {
        section("Lock Group 1"){
            input name: "lockDeviceGroup1", type: "capability.lock", title: "Lock(s)", required: false, multiple: true
            input name: "lockTalkOnUnlock1", type: "text", title: "Say this when unlocked:", required: false, defaultValue: "%devicename% is now %devicechange%"
            input name: "lockTalkOnLock1", type: "text", title: "Say this when locked:", required: false, defaultValue: "%devicename% is now %devicechange%"
            input name: "lockSpeechDevice1", type: "capability.speechSynthesis", title: "Talk with these text-to-speech devices (overrides default)", multiple: true, required: false
        }
        section("Lock Group 2"){
            input name: "lockDeviceGroup2", type: "capability.lock", title: "Lock(s)", required: false, multiple: true
            input name: "lockTalkOnUnlock2", type: "text", title: "Say this when unlocked:", required: false
            input name: "lockTalkOnLock2", type: "text", title: "Say this when locked:", required: false
            input name: "lockSpeechDevice2", type: "capability.speechSynthesis", title: "Talk with these text-to-speech devices (overrides default)", multiple: true, required: false
        }
        section("Lock Group 3"){
            input name: "lockDeviceGroup3", type: "capability.lock", title: "Lock(s)", required: false, multiple: true
            input name: "lockTalkOnUnlock3", type: "text", title: "Say this when unlocked:", required: false
            input name: "lockTalkOnLock3", type: "text", title: "Say this when locked:", required: false
            input name: "lockSpeechDevice3", type: "capability.speechSynthesis", title: "Talk with these text-to-speech devices (overrides default)", multiple: true, required: false
        }
    }
//End pageConfigLock()
}

def pageConfigContact(){
    dynamicPage(name: "pageConfigContact", title: "Configure talk on contact sensor", install: false, uninstall: false) {
        section("Contact Group 1"){
            input name: "contactDeviceGroup1", type: "capability.contactSensor", title: "Contact sensor(s)", required: false, multiple: true
            input name: "contactTalkOnOpen1", type: "text", title: "Say this when opened:", required: false, defaultValue: "%devicename% is now %devicechange%"
            input name: "contactTalkOnClose1", type: "text", title: "Say this when closed:", required: false, defaultValue: "%devicename% is now %devicechange%"
            input name: "contactSpeechDevice1", type: "capability.speechSynthesis", title: "Talk with these text-to-speech devices (overrides default)", multiple: true, required: false
        }
        section("Contact Group 2"){
            input name: "contactDeviceGroup2", type: "capability.contactSensor", title: "Contact sensor(s)", required: false, multiple: true
            input name: "contactTalkOnOpen2", type: "text", title: "Say this when opened:", required: false
            input name: "contactTalkOnClose2", type: "text", title: "Say this when closed:", required: false
            input name: "contactSpeechDevice2", type: "capability.speechSynthesis", title: "Talk with these text-to-speech devices (overrides default)", multiple: true, required: false
        }
        section("Contact Group 3"){
            input name: "contactDeviceGroup3", type: "capability.contactSensor", title: "Contact sensor(s)", required: false, multiple: true
            input name: "contactTalkOnOpen3", type: "text", title: "Say this when opened:", required: false
            input name: "contactTalkOnClose3", type: "text", title: "Say this when closed:", required: false
            input name: "contactSpeechDevice3", type: "capability.speechSynthesis", title: "Talk with these text-to-speech devices (overrides default)", multiple: true, required: false
        }
    }
//End pageConfigContact()
}

def pageConfigMode(){
    dynamicPage(name: "pageConfigMode", title: "Configure talk on home mode change", install: false, uninstall: false) {
        section(){
            input name: "modePhraseGroup1", type: "mode", title: "Home Modes", required: false, multiple: true
            input name: "TalkOnModeChange1", type: "text", title: "Say this when home mode is changed", required: false, defaultValue: "%locationname% mode has changed from %lastmode% to %mode%"
            input name: "modePhraseSpeechDevice1", type: "capability.speechSynthesis", title: "Talk with these text-to-speech devices (overrides default)", multiple: true, required: false
        }
    }
//End pageConfigMode()
}

def pageConfigThermostat(){
    dynamicPage(name: "pageConfigThermostat", title: "Configure talk when thermostat state is:", install: false, uninstall: false) {
        section("Contact Group 1"){
            input name: "thermostatDeviceGroup1", type: "capability.thermostat", title: "Thermostat(s)", required: false, multiple: true
            input name: "thermostatTalkOnIdle1", type: "text", title: "Say this on change to Idle:", required: false, defaultValue: "%devicename% is now off"
            input name: "thermostatTalkOnHeating1", type: "text", title: "Say this on change to heating:", required: false, defaultValue: "%devicename% is now heating"
            input name: "thermostatTalkOnCooling1", type: "text", title: "Say this on change to cooling:", required: false, defaultValue: "%devicename% is now cooling"
            input name: "thermostatTalkOnFan1", type: "text", title: "Say this on change to fan only:", required: false, defaultValue: "%devicename% is now circulating fan"
            input name: "thermostatSpeechDevice1", type: "capability.speechSynthesis", title: "Talk with these text-to-speech devices (overrides default)", multiple: true, required: false
        }
/*        
        section("Contact Group 2"){
            input name: "contactDeviceGroup2", type: "capability.contactSensor", title: "Contact sensor(s)", required: false, multiple: true
            input name: "contactTalkOnOpen2", type: "text", title: "Say this when opened:", required: false, defaultValue: "%devicename% is now %devicechange%"
            input name: "contactTalkOnClose2", type: "text", title: "Say this when closed:", required: false, defaultValue: "%devicename% is now %devicechange%"
            input name: "contactSpeechDevice2", type: "capability.speechSynthesis", title: "Talk with these text-to-speech devices (overrides default)", multiple: true, required: false
        }
        section("Contact Group 3"){
            input name: "contactDeviceGroup3", type: "capability.contactSensor", title: "Contact sensor(s)", required: false, multiple: true
            input name: "contactTalkOnOpen3", type: "text", title: "Say this when opened:", required: false, defaultValue: "%devicename% is now %devicechange%"
            input name: "contactTalkOnClose3", type: "text", title: "Say this when closed:", required: false, defaultValue: "%devicename% is now %devicechange%"
            input name: "contactSpeechDevice3", type: "capability.speechSynthesis", title: "Talk with these text-to-speech devices (overrides default)", multiple: true, required: false
        }
*/
    }
//End pageConfigContact()
}

def installed() {
	state.installed = true
    LOGTRACE("Installed with settings: ${settings}")

	initialize()
//End installed()
}

def updated() {
	LOGTRACE("Updated with settings: ${settings}")

	unsubscribe()
	initialize()
//End updated()
}

def initialize() {
    setAppVersion()
    //Subscribe Motions
    if (motionDeviceGroup1) { subscribe(motionDeviceGroup1, "motion", onMotion1Event) }
    if (motionDeviceGroup2) { subscribe(motionDeviceGroup2, "motion", onMotion2Event) }
    if (motionDeviceGroup3) { subscribe(motionDeviceGroup3, "motion", onMotion3Event) }
    //Subscribe Switches
    if (switchDeviceGroup1) { subscribe(switchDeviceGroup1, "switch", onSwitch1Event) }
    if (switchDeviceGroup2) { subscribe(switchDeviceGroup2, "switch", onSwitch2Event) }
    if (switchDeviceGroup3) { subscribe(switchDeviceGroup3, "switch", onSwitch3Event) }
    //Subscribe Presence
    if (presDeviceGroup1) { subscribe(presDeviceGroup1, "presence", onPresence1Event) }
    if (presDeviceGroup2) { subscribe(presDeviceGroup2, "presence", onPresence2Event) }
    if (presDeviceGroup3) { subscribe(presDeviceGroup3, "presence", onPresence3Event) }
    //Subscribe Lock
    if (lockDeviceGroup1) { subscribe(lockDeviceGroup1, "lock", onLock1Event) }
    if (lockDeviceGroup2) { subscribe(lockDeviceGroup2, "lock", onLock2Event) }
    if (lockDeviceGroup3) { subscribe(lockDeviceGroup3, "lock", onLock3Event) }
    //Subscribe Contact
    if (contactDeviceGroup1) { subscribe(contactDeviceGroup1, "contact", onContact1Event) }
    if (contactDeviceGroup2) { subscribe(contactDeviceGroup2, "contact", onContact2Event) }
    if (contactDeviceGroup3) { subscribe(contactDeviceGroup3, "contact", onContact3Event) }
    //Subscribe Thermostat
    if (thermostatDeviceGroup1) { subscribe(thermostatDeviceGroup1, "thermostatOperatingState", onThermostat1Event) }
    if (thermostatDeviceGroup2) { subscribe(thermostatDeviceGroup2, "thermostatOperatingState", onThermostat2Event) }
    if (thermostatDeviceGroup3) { subscribe(thermostatDeviceGroup3, "thermostatOperatingState", onThermostat3Event) }
    //Subscribe Mode
    if (modePhraseGroup1) { subscribe(location, onModeChangeEvent) }
    state.lastMode = location.mode
	LOGTRACE("Initialized")
    
//End initialize()
}

//BEGIN HANDLE MOTIONS
def onMotion1Event(evt){
    processMotionEvent(1, evt)
}
def onMotion2Event(evt){
    processMotionEvent(2, evt)
}
def onMotion3Event(evt){
    processMotionEvent(3, evt)
}

def processMotionEvent(index, evt){
    LOGDEBUG("(onMotionEvent): ${evt.name}, ${index}, ${evt.value}")
    state.TalkPhrase = null
    state.speechDevice = null
    if (evt.value == "active") {
        if (index == 1) { state.TalkPhrase = settings.motionTalkActive1; state.speechDevice = motionSpeechDevice1}
        if (index == 2) { state.TalkPhrase = settings.motionTalkActive2; state.speechDevice = motionSpeechDevice2}
        if (index == 3) { state.TalkPhrase = settings.motionTalkActive3; state.speechDevice = motionSpeechDevice3}
        Talk(state.TalkPhrase, state.speechDevice, evt)
    }
    if (evt.value == "inactive") {
        if (index == 1) { state.TalkPhrase = settings.motionTalkInactive1; state.speechDevice = motionSpeechDevice1}
        if (index == 2) { state.TalkPhrase = settings.motionTalkInactive2; state.speechDevice = motionSpeechDevice2}
        if (index == 3) { state.TalkPhrase = settings.motionTalkInactive3; state.speechDevice = motionSpeechDevice3}
        Talk(state.TalkPhrase, state.speechDevice, evt)
    }
    state.TalkPhrase = null
    state.speechDevice = null
}
//END HANDLE MOTIONS


//BEGIN HANDLE SWITCHES
def onSwitch1Event(evt){
    processSwitchEvent(1, evt)
}

def onSwitch2Event(evt){
    processSwitchEvent(2, evt)
}

def processSwitchEvent(index, evt){
    LOGDEBUG("(onSwitchEvent): ${evt.name}, ${index}, ${evt.value}")
    state.TalkPhrase = null
    state.speechDevice = null
    if (evt.value == "on") {
        if (index == 1) { state.TalkPhrase = settings.switchTalkOn1; state.speechDevice = switchSpeechDevice1}
        if (index == 2) { state.TalkPhrase = settings.switchTalkOn2; state.speechDevice = switchSpeechDevice2}
        if (index == 3) { state.TalkPhrase = settings.switchTalkOn3; state.speechDevice = switchSpeechDevice3}
        Talk(state.TalkPhrase, state.speechDevice, evt)
    }
    if (evt.value == "off") {
        if (index == 1) { state.TalkPhrase = settings.switchTalkOff1; state.speechDevice = switchSpeechDevice1}
        if (index == 2) { state.TalkPhrase = settings.switchTalkOff2; state.speechDevice = switchSpeechDevice2}
        if (index == 3) { state.TalkPhrase = settings.switchTalkOff3; state.speechDevice = switchSpeechDevice3}
        Talk(state.TalkPhrase, state.speechDevice, evt)
    }
    state.TalkPhrase = null
    state.speechDevice = null
}
//END HANDLE SWITCHES

//BEGIN HANDLE PRESENCE
def onPresence1Event(evt){
    processPresenceEvent(1, evt)
}
def onPresence2Event(evt){
    processPresenceEvent(2, evt)
}
def onPresence3Event(evt){
    processPresenceEvent(3, evt)
}

def processPresenceEvent(index, evt){
    LOGDEBUG("(onPresenceEvent): ${evt.name}, ${index}, ${evt.value}")
    state.TalkPhrase = null
    state.speechDevice = null
    if (evt.value == "present") {
        if (index == 1) { state.TalkPhrase = settings.presTalkOnArrive1; state.speechDevice = presSpeechDevice1}
        if (index == 2) { state.TalkPhrase = settings.presTalkOnArrive2; state.speechDevice = presSpeechDevice2}
        if (index == 3) { state.TalkPhrase = settings.presTalkOnArrive3; state.speechDevice = presSpeechDevice3}
        Talk(state.TalkPhrase, state.speechDevice, evt)
    }
    if (evt.value == "not present") {
        if (index == 1) { state.TalkPhrase = settings.presTalkOnLeave1; state.speechDevice = presSpeechDevice1}
        if (index == 2) { state.TalkPhrase = settings.presTalkOnLeave2; state.speechDevice = presSpeechDevice2}
        if (index == 3) { state.TalkPhrase = settings.presTalkOnLeave3; state.speechDevice = presSpeechDevice3}
        Talk(state.TalkPhrase, state.speechDevice, evt)
    }
    state.TalkPhrase = null
    state.speechDevice = null
}
//END HANDLE PRESENCE

//BEGIN HANDLE LOCK
def onLock1Event(evt){
    LOGDEBUG("onLock1Event(evt) ${evt.value}")
    processLockEvent(1, evt)
}
def onLock2Event(evt){
    processLockEvent(2, evt)
}
def onLockEvent(evt){
    processLockEvent(3, evt)
}

def processLockEvent(index, evt){
    LOGDEBUG("(onLockEvent): ${evt.name}, ${index}, ${evt.value}")
    state.TalkPhrase = null
    state.speechDevice = null
    if (evt.value == "locked") {
        if (index == 1) { state.TalkPhrase = settings.lockTalkOnLock1; state.speechDevice = lockSpeechDevice1}
        if (index == 2) { state.TalkPhrase = settings.lockTalkOnLock2; state.speechDevice = lockSpeechDevice2}
        if (index == 3) { state.TalkPhrase = settings.lockTalkOnLock3; state.speechDevice = lockSpeechDevice3}
        Talk(state.TalkPhrase, state.speechDevice, evt)
    }
    if (evt.value == "unlocked") {
        if (index == 1) { state.TalkPhrase = settings.lockTalkOnUnlock1; state.speechDevice = lockSpeechDevice1}
        if (index == 2) { state.TalkPhrase = settings.lockTalkOnUnlock2; state.speechDevice = lockSpeechDevice2}
        if (index == 3) { state.TalkPhrase = settings.lockTalkOnUnlock3; state.speechDevice = lockSpeechDevice3}
        Talk(state.TalkPhrase, state.speechDevice, evt)
    }
    state.TalkPhrase = null
    state.speechDevice = null
}
//END HANDLE LOCK

//BEGIN HANDLE CONTACT
def onContact1Event(evt){
    processContactEvent(1, evt)
}
def onContact2Event(evt){
    processContactEvent(2, evt)
}
def onContactEvent(evt){
    processContactEvent(3, evt)
}

def processContactEvent(index, evt){
    LOGDEBUG("(onContactEvent): ${evt.name}, ${index}, ${evt.value}")
    state.TalkPhrase = null
    state.speechDevice = null
    if (evt.value == "open") {
        if (index == 1) { state.TalkPhrase = settings.contactTalkOnOpen1; state.speechDevice = contactSpeechDevice1}
        if (index == 2) { state.TalkPhrase = settings.contactTalkOnOpen2; state.speechDevice = contactSpeechDevice2}
        if (index == 3) { state.TalkPhrase = settings.contactTalkOnOpen3; state.speechDevice = contactSpeechDevice3}
        Talk(state.TalkPhrase, state.speechDevice, evt)
    }
    if (evt.value == "closed") {
        if (index == 1) { state.TalkPhrase = settings.contactTalkOnClose1; state.speechDevice = contactSpeechDevice1}
        if (index == 2) { state.TalkPhrase = settings.contactTalkOnClose2; state.speechDevice = contactSpeechDevice2}
        if (index == 3) { state.TalkPhrase = settings.contactTalkOnClose3; state.speechDevice = contactSpeechDevice3}
        Talk(state.TalkPhrase, state.speechDevice, evt)
    }
    state.TalkPhrase = null
    state.speechDevice = null
}
//END HANDLE CONTACT

//BEGIN MODE CHANGE
def onModeChangeEvent(evt){
    processModeChangeEvent(1, evt)
}
def processModeChangeEvent(index, evt){
    LOGDEBUG("(onModeEvent): Last Mode: ${state.lastMode}, New Mode: ${location.mode}")
    state.proceed = false
    modePhraseGroup1.each(){
      if (it == location.mode){state.proceed = true}
    }
    if (!(state.proceed)) { return }
    state.TalkPhrase = null
    state.speechDevice = null
    state.TalkPhrase = settings.TalkOnModeChange1; state.speechDevice = modePhraseSpeechDevice1
    Talk(state.TalkPhrase, state.speechDevice, evt)
    state.TalkPhrase = null
    state.speechDevice = null
    state.lastMode = location.mode
}
//END MODE CHANGE

//BEGIN HANDLE THERMOSTAT
def onThermostat1Event(evt){
    processThermostatEvent(1, evt)
}
def onThermostat2Event(evt){
    processThermostatEvent(2, evt)
}
def onThermostatEvent(evt){
    processThermostatEvent(3, evt)
}

def processThermostatEvent(index, evt){
    LOGDEBUG("(onThermostatEvent): ${evt.name}, ${index}, ${evt.value}")
    state.TalkPhrase = null
    state.speechDevice = null
    if (evt.value == "idle") {
        if (index == 1) { state.TalkPhrase = settings.thermostatTalkOnIdle1; state.speechDevice = thermostatSpeechDevice1}
        if (index == 2) { state.TalkPhrase = settings.thermostatTalkOnIdle2; state.speechDevice = thermostatSpeechDevice2}
        if (index == 3) { state.TalkPhrase = settings.thermostatTalkOnIdle3; state.speechDevice = thermostatSpeechDevice3}
        Talk(state.TalkPhrase, state.speechDevice, evt)
    }
    if (evt.value == "heating") {
        if (index == 1) { state.TalkPhrase = settings.thermostatTalkOnHeating1; state.speechDevice = thermostatSpeechDevice1}
        if (index == 2) { state.TalkPhrase = settings.thermostatTalkOnHeating2; state.speechDevice = thermostatSpeechDevice2}
        if (index == 3) { state.TalkPhrase = settings.thermostatTalkOnHeating3; state.speechDevice = thermostatSpeechDevice3}
        Talk(state.TalkPhrase, state.speechDevice, evt)
    }
    if (evt.value == "cooling") {
        if (index == 1) { state.TalkPhrase = settings.thermostatTalkOnCooling1; state.speechDevice = thermostatSpeechDevice1}
        if (index == 2) { state.TalkPhrase = settings.thermostatTalkOnCooling2; state.speechDevice = thermostatSpeechDevice2}
        if (index == 3) { state.TalkPhrase = settings.thermostatTalkOnCooling3; state.speechDevice = thermostatSpeechDevice3}
        Talk(state.TalkPhrase, state.speechDevice, evt)
    }
    if (evt.value == "fan only") {
        if (index == 1) { state.TalkPhrase = settings.thermostatTalkOnFan1; state.speechDevice = thermostatSpeechDevice1}
        if (index == 2) { state.TalkPhrase = settings.thermostatTalkOnFan2; state.speechDevice = thermostatSpeechDevice2}
        if (index == 3) { state.TalkPhrase = settings.thermostatTalkOnFan3; state.speechDevice = thermostatSpeechDevice3}
        Talk(state.TalkPhrase, state.speechDevice, evt)
    }

    state.TalkPhrase = null
    state.speechDevice = null
}
//END HANDLE THERMOSTAT

def processPhraseVariables(phrase, evt){
    phrase = phrase.replace('%devicename%', evt.displayName)  //User given name of the device
    phrase = phrase.replace('%devicetype%', evt.name)  //Device type: motion, switch, etc...
    phrase = phrase.replace('%devicechange%', evt.value)  //State change that occurred: on/off, active/inactive, etc...
    phrase = phrase.replace('%locationname%', location.name)
    phrase = phrase.replace('%lastmode%', state.lastMode)
    phrase = phrase.replace('%mode%', location.mode)
    return phrase
}

def Talk(phrase, customSpeechDevice, evt){
    def currentSpeechDevices = []
    if (!(phrase == null)) {
        phrase = processPhraseVariables(phrase, evt)
        if (!(customSpeechDevice == null)) {
            currentSpeechDevices = customSpeechDevice
        } else {
            //Use Default Speech Device
            currentSpeechDevices = settings.speechDeviceDefault
        }
        //Iterate Speech Devices and talk
        LOGDEBUG("TALK >> ${phrase}")
        currentSpeechDevices.each(){
            def currentStatus = it.currentValue("status")
            def currentTrack = it.currentState("trackData")?.jsonValue
            def currentVolume = it.currentState("level")?.integerValue ? it.currentState("level")?.integerValue : 0
            LOGDEBUG("${it.displayName} | Volume: ${currentVolume}")
            if (!(currentTrack == null)){
                //currentTrack has data
                LOGDEBUG("${it.displayName} | Current Status: ${currentStatus}, CurrentTrack: ${currentTrack}, CurrentTrack.Status: ${currentTrack.status}.")
                if (currentTrack.status == 'playing') {
                    LOGDEBUG("${it.displayName} | Resuming play. Sending playTextAndResume().")
                    it.playTextAndResume(phrase)
                } else
                {
                    LOGDEBUG("${it.displayName} | Nothing playing. Sending playTextAndResume()")
                    it.playTextAndResume(phrase) //Let's just call playTextAndResume() anyway
                }
            } else {
                //currentTrack doesn't have data or is not supported on this device
                if (currentStatus == "disconnected") {
                    //VLCThing?
                    LOGDEBUG("${it.displayName} | VLCThing? | Current Status: ${currentStatus}.")
                    it.playText(phrase) //VLCThing speaks only part of the phrase if using playTextAndResume() or playTextAndRestore 12/15/2014
                } else {
                    LOGDEBUG("${it.displayName} | Current Status: ${currentStatus}. Sending playTextAndRestore().")
                    it.playTextAndResume(phrase) //Let's just call playTextAndRestore() anyway
                }
            }
        }
    }
}

def LOGDEBUG(txt){
    log.debug("BIGTALKER | ${txt}")
}
def LOGTRACE(txt){
    log.trace("BIGTALKER | ${txt}")
}
def setAppVersion(){
    state.appversion = "1.0.1"
}
