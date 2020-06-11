rm -rf Newspaper/bin
mkdir Newspaper/bin
find Newspaper/src -type f -name '*.java' -exec javac -d Newspaper/bin -cp Newspaper/lib/junit3.8.1.jar {} +


testCases=(`find Newspaper/bin/com/test -type f -name '*.class'`)


for test in "${testCases[@]}"
do
    filename=$(basename "$test")
    parent1="$(basename "$(dirname "$test")")"
    parent2="$(basename "$(dirname "$(dirname "$test")")")"
    file="${filename%.*}"
   
    java -cp Newspaper/bin:Newspaper/lib/junit3.8.1.jar junit.textui.TestRunner "$parent2.$parent1.$file"

    if [ $? -ne 0 ]; then
        exit 1;
    fi   
done
cd Newspaper/bin
find com -type f -name '*.class' -exec jar cfe Newspaper.jar com.controller.BasicCalc {} +
