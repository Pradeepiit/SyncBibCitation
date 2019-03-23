# Synchronizing the bibliographic listing with the citations in LATEX tex files.

The research article writing includes adding the bibiliographic list with their respective citations in the main document. Lot of time is spent in checking the bibiliographic entries against the citations in the paper. Even though, missing bibitems are identfied from the output PDF the uncited bibitems are usually added to the PDF. Manual comparison in journal and thesis writing is time consuming and hectic. This process can be automated using a small script. This code base just does exactly the same.

## Executing the code.
Just replace the `FILE_LOCATION_LATEX` and `FILE_LOCATION_BIB` variables with the respective latex and bibtex files. If the bibiliography list is added to the main tex file then provide both the filenames to be tex file.

## Significant Advantages
* Ignore the synchronization of bibiliographic listing and citations in the main document.
* This code automatically displays the label of extra bibiliographic references.
* This code automatically displays the label of the cited reference unavailable in the bibiliographic references.

## Author contact info
For any queries or suggestion please do revert back to pradeeprengaswamy@gmail.com
