#!/usr/bin/env bash
#
# Date: 25/10/26
# Description: To crate groovy stanalones and
#              projects in groovy programming language.
# Author: omitida - Code-Cratsfman
#
#
function usage() {
    echo "Usage: ${0} -<option> <filename>";
    echo ""
    echo "Options Available"
    echo "-----------------"
    echo ""
    "echo "c:    Compile a groovy project or standalone program file.""
    echo "d:    Delete specified file or project file."
    "echo "g:    Create a groovy generic project.""
    echo "h:    Display this helper/usage function."
    echo "o:    Create a standalone groovy program file."
    echo "r:    Run a compiled groovy project or standalone program file."
    "echo "s:    open and run jshell for groovy.""
    "echo "j:    Create a jar file from a compiled groovy project or standalone program file.""
    "echo "x:    Create, compile, and run a groovyfx program""
    echo ""
}

filename=


# debug function
function debug() {
    echo "debug: ${*}"; exit;
}

GROOVY_PLAIN_FILE="println \"Starts Here!.\""


function check_ext(){
    file="${1}"
    filename="${file%.*}"
    extname="${file##*.}"
    [[ "${filename}" = "${extname}" ]] && file="${file}.groovy"
    filename="${file}"
}

# gateway code to check how many arguments were
# provided on the cli
[[ "$#" -lt 2 ]] && { usage; exit 1; }

#option_string="c:d:g:o:r:j:s:x:h"
option_string="d:o:r:h"
while getopts "${option_string}" opt; do
case "${opt}" in
    c)
        # echo "Compiling a groovy program.."
        # filename="${OPTARG}"
        # check_ext "${filename}"
        # file="${filename%.*}"
        # javac -d . "${filename}"  # compiles
        ;;
    d)
        echo "Deleting groovy file.."
        filename="${OPTARG}"
        ! [[ -e "${filename}" ]] && { echo "${filename} file or directory does not exist."; exit 1; }
        while read -r -p "Are you sure you want to delete ${filename}? (y/n) " ans; do
            case "${ans}" in
                [Yy])
                   if [[ -f "${filename}" ]]; then
                       rm -f "${filename}" # remove file
                       # search for the file in the directory com/practice
                       # and delete the directory with the name of the package
                       dirname_to_delete=$(basename "${filename%.*}")
                       find com/practice -type d -name "${dirname_to_delete,}" -exec rm -rf {} \;
                   fi
                   [[ -d "${filename}" ]] && rm -rf "${filename}"
                   echo "Deleted ${filename}."
                    break;;
                [Nn])
                    echo "Cancelled deletion of ${filename}."
                    break;;
                *) echo "Invalid input. Please enter 'y' or 'n'.";;
            esac
        done
        ;;
    g)
        #echo "Generating standalone groovy file.."
        #filename="${OPTARG}"
        #check_ext "${filename}"
        #file="${filename%.*}"
        #echo "${JAVA_PLAIN_FILE}" > "${filename^}"
        #perl -pe "s|<packagename_place_holder>|${file,,}|;
        #          s|<classname_place_holder>|${file^}|" "${filename^}" > "${filename}_tmp"
        #mv "${filename}_tmp" "${filename^}"  # move the temporary file to the original filename

        # make a directory with the package structure to move groovy file into
        #groovy_project_path="${file^}/com/practice/${file,,}"
        #mkdir -p "${groovy_project_path}"  # create the directory if it doesn't exist
        #filename="${filename^}"
        #mv "${filename}" "${groovy_project_path}/"  # move the groovy file into the directory

        #cd "${file^}" || exit
        #javac -d out "com/practice/${file,,}/${filename}"
        #java -cp out "com.practice.${file,,}.${file^}"
        ;;
    o)
        echo "Generating standalone groovy file.."
        filename="${OPTARG}"
        check_ext "${filename}"
        file="${filename%.*}"
        echo "${GROOVY_PLAIN_FILE}" > "${filename^}"
        perl -pe "s|<packagename_place_holder>|${file,,}|;
                  s|<classname_place_holder>|${file^}|" "${filename^}" > "${filename}_tmp"
        mv "${filename}_tmp" "${filename^}"
        #javac -d . "${filename}"
        #java -cp . "com.practice.${file,,}.${file^}"
        ;;
    r)
        echo "Running a groovy program.."
        filename="${OPTARG}"
        check_ext "${filename}"
        file="${filename%.*}"
        #javac -d . "${filename}"  # compiles
        #java -cp . "com/practice/${file,,}/${file^}" # runs the program
        ;;
    s) #echo "Launching jshell for groovy...."
        #jshell
        ;;
    j)
       # echo "Creating a jar file.."
        # make a manifest file
        #filename="${OPTARG}"
        #check_ext "${filename}"
        #file="${filename%.*}"
        #javac -d . *.groovy
        #echo "Main-Class: com.practice.${file,,}.${file^}" > manifest.txt
        #echo "" >> manifest.txt
        #jar cvfm "${file}.jar" manifest.txt com
        #java -jar "${file}.jar"
        ;;
    x)
        #echo "Creating, compiling, and running a javafx program.."
        #filename="${OPTARG^}"
        #check_ext "${filename}"
        #file="${filename%.*}"

        #echo "${JAVA_FX_FILE}" > "${file}.java"

        #perl -pe "s|<packagename_place_holder>|${file,,}|;
         #         s|<classname_place_holder>|${file}|" "${filename}" > "${filename}_tmp"

        #mv "${filename}_tmp" "${filename%.*}FX.java"; rm "${file}.java"
        #file="${filename%.*}FX.java"

        #javac -d . \
        #--module-path "${JAVAFX_HOME}" \
        #--add-modules groovyfx.controls \
        #"${file}"

        #file="${file%.*}"

        #java -cp . \
        #--enable-native-access=groovyfx.graphics \
        #--module-path "${JAVAFX_HOME}" \
        #--add-modules groovyfx.controls \
        #"com.practice.${file,}.${file^}"
        ;;
    h)
        usage
        ;;
    *);;
esac
done
