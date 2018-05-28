## EMV PARSER

This is a simple Kotlin Application built as a coding challenge with the following requirements

Write an Android app in Kotlin that does the following:

Given a string in the form of a TLV (Tag-Legnth-Value) data object from an EMV transaction
(1) Parse and decode the TLV and
(2) Display to the user the tag, tag meaning, and value for each element in the TLV.
(3) Include an automated test (UI or Unit).

You are free to write and implement this how ever you’d like with whatever resources or 3rd party code you’d like. Feel free to ask questions at any time (jake@payclip.com) and take as long as you need.

## What I did

- Created a kotlin APP that decodes the two examples given or grabs a custom example from a text field.

- Integrated with the (awesome) decoding library from [binaryfoo](https://github.com/binaryfoo/emv-bertlv)

- Wrote a simple parser that decodes the data and parses it to an arrayList of a custom model instance

- Shows an error alert if the input data is invalid for decoding or show a list in a dialog fragment with the decoded tags.

- Wrote a few UI automated tests with espresso.

## RUN THE PROJECT

 - Clone this repository:
 ```
 git clone https://github.com/luisgj/tlv-decoder.git
 ```
- Run the project in Android Studio

## RUN TESTS

- Connect a device or emulator

- Make sure de device screen is on.

- Run from command line:
```
./gradlew connectedAndroidTest
```

Check it out!