# Synchronizing the bibliographic listing with the citations in LATEX tex files.

The research article writing includes adding the bibiliographic list with their respective citations in the main document. Lot of time is spent in checking the bibiliographic entries against the citations in the paper. Even though, missing bibitems are identfied from the output PDF the uncited bibitems are usually missedout. This code base just helps you over this problem.

## The code is implemented in Java and assumes bibitem and cite functions are used in the same tex file. 
This code compares the keywords used in bibitem and cite functions and displayes the missing entries in both citations and bibilographic list. 

## Executing the code.
Just replace the FILE_LOCATION_LATEX and FILE_LOCATION_BIB variable with the respective latex and bibtex files. If the bibiliography list is added to the main tex file then provide both the filenames to be tex file.
