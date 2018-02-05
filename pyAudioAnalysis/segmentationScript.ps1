param (
[Parameter(Mandatory=$true)][string] $wavFile
)

$currPath = Get-Location
$suffix = "\pyAudioAnalysis"
$newP = "$currPath$suffix"

# Works when script is executed from java
Set-Location $newP

#python C:/Users/Florian/IdeaProjects/Audioanalyzer/pyAudioAnalysis/audioAnalysis.py segmentClassifyFile -i C:/Users/Florian/IdeaProjects/Audioanalyzer/pyAudioAnalysis/data/scottish.wav --model svm --modelName C:/Users/Florian/IdeaProjects/Audioanalyzer/pyAudioAnalysis/data/svmSM
#python C:/Users/Florian/IdeaProjects/Audioanalyzer/pyAudioAnalysis/audioAnalysis.py segmentClassifyFile -i $A --model svm --modelName C:/Users/Florian/IdeaProjects/Audioanalyzer/pyAudioAnalysis/data/svmSM
#python audioAnalysis.py segmentClassifyFile -i data/scottish.wav --model svm --modelName data/svmSM


#python audioAnalysis.py segmentClassifyFile -i C:/Users/Florian/Desktop/scottish.wav --model svm --modelName data/svmSM
python audioAnalysis.py segmentClassifyFile -i $wavFile --model svm --modelName data/svmSM


Out-File -FilePath C:\Users\Florian\Desktop\process.txt -InputObject $newP -Encoding ASCII -Width 50