for i in `unzip -l archieve.zip` 
do 
if [[ $i == *log ]] 
then 
echo $i
unzip -c archieve.zip $i | grep "phaseName=DO_BUILD"
fi
done
