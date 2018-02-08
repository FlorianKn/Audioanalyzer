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

python audioAnalysis.py speakerDiarization -i $wavFile --num $speaker