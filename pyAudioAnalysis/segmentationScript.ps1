# Path to wav file
param (
[Parameter(Mandatory=$true)][string] $wavFile
)

$currPath = Get-Location
$suffix = "\pyAudioAnalysis"
$newP = "$currPath$suffix"

# Works when script is executed from java
Set-Location $newP
# Execute python 
python audioAnalysis.py segmentClassifyFile -i $wavFile --model svm --modelName data/svmSM