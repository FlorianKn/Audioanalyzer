param (
# Path to wav file
[Parameter(Mandatory=$true)][string] $wavFile,
# Number of speakers
[Parameter(Mandatory=$true)][int] $speaker
)

$currPath = Get-Location
$suffix = "\pyAudioAnalysis"
$newP = "$currPath$suffix"

# Works when script is executed from java
Set-Location $newP

#Out-File -FilePath C:\Users\Florian\Desktop\process.txt -InputObject $wavFile, $speaker -Encoding ASCII -Width 50

#Set-Location C:\Users\Florian\IdeaProjects\Audioanalyzer\pyAudioAnalysis
python audioAnalysis.py speakerDiarization -i $wavFile --num $speaker
#python audioAnalysis.py speakerDiarization -i C:\Users\Florian\Desktop\diarizationExample.wav --num 4


#Works
#C:\Users\Florian\Desktop\testEigen705Bit.wav
#C:\Users\Florian\Desktop\diarizationExample.wav
#C:/Users/Florian/Desktop/diarizationExample.wav


#data/testEigen705Bit.wav
#data/diarizationExample.wav
