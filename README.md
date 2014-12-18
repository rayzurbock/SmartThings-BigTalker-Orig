SmartThings-BigTalker
=====================
#License
Copyright (c) 2014 Brian S. Lowrance (brian@rayzurbock.com) <br />
Donations accepted via Paypal, but not required - rayzur@rayzurbock.com

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at:

http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

#Description
Big Talker is a SmartApp that can make your house talk depending on various triggered events. <br />
Pair with any SmartThings compatible speech synthesis audio device such as Sonos, VLC Thing on your computer or Raspberry Pi! <br />
Version: 1.0.1-Beta6

#Installation
1. Login at <a href=http://graph.api.smartthings.com>http://graph.api.smartthings.com</a>
2. Go to "My SmartApps" section and click on the "+ New SmartApp" button on the right.
3. On the "New SmartApp" page, fill out mandatory "Name" and "Description" fields (it does not matter what you put there).
4. Click the "Create" button at the bottom.
5. When a new app template opens in the IDE, replace the contents with that in the .groovy file here
6. Click the blue "Save" button above the editor window.
7. Click the "Publish" button next to it and select "For Me". You have now self-published your SmartApp.
8. Open SmartThings mobile app on iPhone or Android and go to the Dashboard.
9. Tap on the round "+" button and navigate to "My Apps" section by swiping the menu ribbon all the way to the left.
10. "BigTalker" app should be available in the list of SmartApps that appears below the menu ribbon. Tap it.
11. Tap Configure to start setting up your talking events.  Setup as many or as few as you like.

# Revision History
*  12/13/2014 - 1.0.0 - Initial Release
*  12/14/2014 - 1.0.1 - Sonos Support corrected. Resume playback after speaking (not supported for VLC-Thing until the Device Type supports it), Corrected custom speech device save for Switch events, general cleanup.  More event support to come in new releases soon. Special thanks to SmartThings community member Greg for help with testing Sonos functionality and making this release possible.

# More Details
Have you ever wanted a talking house? Now you can! With my Big Talker SmartApp ( http://github.com/rayzurbock/SmartThings-BigTalker )

When SmartThings is paired with a speech synthesis device (such as a Sonos or VLC Thing ( http://community.smartthings.com/t/vlc-thing-a-poor-mans-sonos/5433 )) and my Big Talker SmartApp, your house can say what you want it to say when events occur.

Currently supported events:

* Motion, Active/Inactive
* Switch, On/Off
* Presence, Arrive/Depart
* Lock, Lock/Unlock
* Contact, Open/Close
* Mode, Change (Home, Away, etc)
* Thermostat, Cooling/Heating/Fan/Idle(not running)

Each supported event supports 3 different groups so that you can alter your spoken phrases based on which group your selection of devices is configured in.

Voice phrases support the following variables (to be filled in at runtime)

* %devicename% = Triggering devices display name
* %devicetype% = Triggering device type; motion, switch, etc...
* %devicechange% = State change that occurred; on/off, active/inactive, etc...
* %locationname% = Hub Location name; home, work, etc...
* %lastmode% = Last home mode; home, away, etc...
* %mode% = Current home mode; home, away, etc...

For example when turning off a switch named "Office Light" with a spoken phrase of "%devicename% %devicetype% has been turned %devicechange%" would speak "Office light switch has been turned off"

I have a virtual switch that turns on/off all of my Christmas tree's and interior Christmas lights. I configured Big Talker's switch event for Group 1 with this virtual switch and when turned on to speak "Merry Christmas". The family loves it!

Keep in mind, if you configure highly active or too many devices, it may get annoying!! We had a family gathering tonight and the kids kept going in/out the back door to play in the yard. "Back Door has been opened, Back Door has been closed, Back Door has been opened, you get the idea." I wouldn't configure chatty motion sensors either, but that's up to you.

Have Fun!
