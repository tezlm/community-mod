#!/bin/sh
script="sed -i -e "s/  /\t/" **/*.{js,java,groovy}"
echo $script > .git/hooks/pre-commit
