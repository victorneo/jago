# Jago

This is a fork of the original [Jago client][1] version 6.2. The purpose of this project is
to ensure that the Jago client builds cleanly on the latest JDK versions, so
that we can continue to use Jago on modern systems.

Jago was one of the first few Go clients that I have been using many years back
while learning Go, and I plan on doing periodic updates to it so that it can
continue to run for as long as Java supports it.

The current codebase supports _JDK 18_, but with the removal of audio code that
uses the `sun` packages. I plan to add it back someday, if I can figure out how
the original audio code generation works.

## Building

Gradle is used to generate the JAR file to run Jago. Assuming that you have the
JDK installed, the following command will build the project and its the JAR
file.

```
./gradlew build
```

To run Jago, use the following command:

```
java -jar build/libs/jago.jar
```

## Credits

Permission has been granted by the original creator, Rene Grothmann, for this
fork on Github. It is now published under the GPLv3 license.

You may obtain the original copy of the source code via [Jago's website][1].

## License

This program is free software: you can redistribute it and/or modify it under
the terms of the GNU General Public License as published by the Free Software
Foundation, either version 3 of the License, or (at your option) any later
version.

This program is distributed in the hope that it will be useful, but WITHOUT ANY
WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
PARTICULAR PURPOSE.  See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with
this program.  If not, see https://www.gnu.org/licenses/.


[1]: http://jagoclient.sourceforge.net/
