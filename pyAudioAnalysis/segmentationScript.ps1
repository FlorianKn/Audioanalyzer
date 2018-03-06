# Path to wav file
param (
[Parameter(Mandatory=$true)][string] $wavFile,
[Parameter(Mandatory=$true)][string] $model
)

$currPath = Get-Location
$suffix = "\pyAudioAnalysis"
$newP = "$currPath$suffix"

 Out-File -FilePath C:\Users\Florian\Desktop\process.txt -InputObject $model -Encoding ASCII -Width 50

# Works when script is executed from java
Set-Location $newP
if($model.Contains("HMM")) {
    # Execute python
    python audioAnalysis.py segmentClassifyFileHMM --hmm data/hmmRadioSM -i $wavFile
} else {
    # Execute python
    python audioAnalysis.py segmentClassifyFile -i $wavFile --model svm --modelName data/svmSM
}

