# Audioanalyzer
To run python files

1. Install python 2.7.14 from https://www.python.org/downloads/
2. Run "git clone https://github.com/tyiannak/pyAudioAnalysis.git"
3. Download "get-pip.py" from https://stackoverflow.com/questions/4750806/how-do-i-install-pip-on-windows
4. Run "python get-pip.py" on commandline (file has to be in same directory as get-pip.py)
5. Add variable (for example PIP_PY and path (C:\Python27\Scripts)) to systemvariables
6. Add variable to Path (%PIP_PY%)
7. Run "pip install numpy"
8. Run "pip install matplotlib"
9. Download Scipy from http://www.lfd.uci.edu/~gohlke/pythonlibs/#scipy
	9.1 Python 2.7 > cp27 || Python 3.5 > cp35 etc.
	9.2 32-Bit Processor = win32 || 64-Bit Processor = win_adm64
10. Run "pip install scipy-0.19.1-cp27-cp27m-win32.whl"
11. Run "pip install sklearn"
12. Run "pip install hmmlearn"
13. Run "pip install simplejson"
14. Run "pip install eyed3"
15. Run "pip install pydub"
16. Download Numpy + mkl from http://www.lfd.uci.edu/~gohlke/pythonlibs/#numpy
17. Run "pip install numpy-1.13.1+mkl-cp27-cp27m-win32.whl"
18. https://stackoverflow.com/questions/18374103/exception-valuefailed-to-find-libmagic-check-your-installation-in-windows-7
19. https://github.com/ahupp/python-magic#dependencies
20. Download https://sourceforge.net/projects/gnuwin32/files/file/5.03/file-5.03-setup.exe/download?use_mirror=netcologne GNU32
21. Create new systemvariable GNU32 (C:\Program Files (x86)\GnuWin32\bin)
22. Create new systemvariable MAGIC (C:\Program Files (x86)\GnuWin32\share\misc\magic)
23. Add GNU32 and MAGIC to Path Variable (don't forget % before and after variable e.g %GNU32%)
24. Change line 550 in audioTrainTest.py from ""with open(SVMmodelName, 'rb')" to "with open(SVMmodelName, 'r') as fid:" if you get "ImportError: No module named copy_reg"