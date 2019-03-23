import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author R. Pradeep
 * Synchronizing the bibliographic listing to the citations in the paper.
 */
public class RemoveCitation {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
		String wholeTextLatex, wholeTextBib, currentLine[], citation, textInBetween;
		String FILE_LOCATION_LATEX = "latex_template.tex";
		String FILE_LOCATION_BIBTEX = "bib_template.bib";
        File LatexFile = new File(FILE_LOCATION_LATEX);
		File BibFile = new File(FILE_LOCATION_BIBTEX);
        ArrayList<String> listOfCitations = new ArrayList<>();
        ArrayList<String> listOfBibItems = new ArrayList<>();
        

        wholeTextLatex = new String(Files.readAllBytes(LatexFile.toPath()));
		wholeTextBib = new String(Files.readAllBytes(BibFile.toPath()));
        Pattern pattern = Pattern.compile(Pattern.quote("cite{") + "(.*?)" + Pattern.quote("}"));
        Matcher matcher = pattern.matcher(wholeTextLatex);
        while (matcher.find()) {
            textInBetween = matcher.group(1);
            if (textInBetween.contains(",")) {
                String[] splitText = textInBetween.split(",");
                for (String split : splitText) {
                    split = split.trim();
                    if (split.length() > 0) {
                        listOfCitations.add(split);
                    }
                }
            } else {
                textInBetween = textInBetween.trim();
                if (textInBetween.length() > 0) {
                    listOfCitations.add(textInBetween);
                }
            }
        }

        HashSet<String> set = new HashSet<>(listOfCitations);
        set.addAll(listOfCitations);
        listOfCitations.clear();
        listOfCitations.addAll(set);

        // ignore the commented bibitems and check if all the bibitems are cited in the paper
        pattern = Pattern.compile(Pattern.quote("%") + "(.*?)" + Pattern.quote("bibitem"));
        currentLine = wholeTextBib.split("\n");
        for (String currentLine1 : currentLine) {
            matcher = pattern.matcher(currentLine1);
            if (!matcher.find() && currentLine1.contains("bibitem{")) {
                citation = currentLine1.substring(currentLine1.indexOf("{") + 1, currentLine1.indexOf("}"));
                listOfBibItems.add(citation);
                if (!set.contains(citation)) {
                    System.out.println("The bibilographic list includes " + citation + " but is not referred anywhere in the paper.");
                }
            }
        }

        for (String str : listOfCitations) {
            if (!listOfBibItems.contains(str)) {
                System.out.println("The cited article " + str + " is missing in the bibilographic list.");
            }
        }
    }

}
