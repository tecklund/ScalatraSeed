#! /bin/bash

#locale
#uname -a
#mongod --version

#id
#ls -al /data/


mongod --fork --logpath mongod.log

#sleep 4

#cat mongod.log 

./gradlew clean test -Dspecs2.console "$@" #--debug
