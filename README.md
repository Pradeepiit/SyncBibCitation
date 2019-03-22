# Synchronizing the bibliographic listing with the citations in LATEX tex files.

Usually when writing a research article, we copy paste the references from our previously archived data. Lot of time is spent in checking the bibiliographic entries against the citations in the paper. Even though, missing bibitems are identfied from the output PDF the additional bibitems are usually missedout. This code base just helps you over this problem.

## The code is implemented in Java and assumes bibitem and cite functions are used in the same tex file. 
This code compares the keywords used in bibitem and cite functions and displayes the missing entries in both citations and bibilographic list. 
