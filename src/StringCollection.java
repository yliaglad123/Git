import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class StringCollection {
    private List<String> strings;
    private int size;

    public StringCollection(int size) {
        this.strings = new ArrayList<String>();
        this.size = size;
    }

    public void print() {
        System.out.println("Элементы:");
        for(String string: strings) {
            System.out.println(string);
        }
    }

    public void deleteElement(String element) {
        strings.remove(element);
    }

    public void addElement(String element) {
        if(strings.size() == size) {
            strings.remove(0);
        }
        strings.add(element);
    }

    public void findDuplicateElements() {
        int sum = 0;
        Set<String> names = new TreeSet<>();
        int flag=0;
        for(int i = 0; i < strings.size(); ++i) {
            if(names.contains(strings.get(i))) {
                continue;
            }
            for(int j = i + 1; j < strings.size(); ++j) {
                if(strings.get(i).equals(strings.get(j))) {
                    names.add(strings.get(i));
                    ++sum;
                }
            }
            if(sum == 0) {
                continue;
            } else {
                System.out.println(strings.get(i) + " has " + sum + " duplicates");
                sum = 0;
                flag=1;
            }
        }
        if(flag==0) System.out.println("В коллекции нет одинаковых элементов");
    }

    public void reverseElements() {
        System.out.println(strings.size());
        for(int i = 0; i < strings.size(); ++i) {
            StringBuilder stringBuilder = new StringBuilder(strings.get(i));
            strings.set(i, stringBuilder.reverse().toString());
        }
    }

    public void letterCount() {
        String alphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        int sum = 0;
        for(int j = 0; j < alphabet.length(); ++j) {
            for(String string: strings) {
                for(int i = 0; i < string.length(); ++i) {
                    if(alphabet.substring(j, j + 1).equals(string.substring(i, i + 1))) {
                        ++sum;
                    }
                }

            }
            if(sum > 0) {
                System.out.println("Количесво буквы \"" + alphabet.substring(j, j + 1) + "\" - " + sum);
            }
            sum = 0;
        }
    }

    public void findSubstring(String substring) {
        for(String string: strings) {
            if(string.contains(substring)) {
                System.out.println("Элемент " + string + " содержит подстроку " + substring);
            }
        }
    }

    public void countElementsLength() {
        String[] lengths = new String[strings.size()];
        for (int i = 0; i < strings.size(); ++i) {
            lengths[i] = strings.get(i).length() + " " +strings.get(i) ;
        }
        Arrays.sort(lengths);
        for (int j = 0; j < lengths.length; ++j) {
            System.out.print(lengths[j]);
            System.out.println();
        }
    }

    public int compareInnerObjects(int firstIndex, int secondIndex) {
        return strings.get(firstIndex).compareTo(strings.get(secondIndex));
    }

    public void initializeFromFile() {
        Scanner file = null;
        try {
            file = new Scanner(new File("data.txt"));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        while (file.hasNextLine()) {
            if(strings.size() == size) {
                strings.remove(0);
            }
            strings.add(file.nextLine());
        }
    }

    public void createXML() {
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = documentFactory.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        }

        Document document = documentBuilder.newDocument();

        Element root = document.createElement("list");
        document.appendChild(root);

        for(String string: strings) {
            Element el = document.createElement("element");
            el.appendChild(document.createTextNode(string));
            root.appendChild(el);
        }

        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("xmlData.xml"));
            transformer.transform(domSource, streamResult);
        } catch (TransformerException ex) {
            ex.printStackTrace();
        }
    }
}


