import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Filereader {
    String database = "";
    ArrayList<String> names=new ArrayList<String>();
    ArrayList<String> users=new ArrayList<String>();
    ArrayList<String> passwords=new ArrayList<String>();
    ArrayList<String> majors=new ArrayList<String>();
    ArrayList<String> orientations=new ArrayList<String>();
    ArrayList<String> supervisers=new ArrayList<String>();
    ArrayList<String> activecourses =new ArrayList<String>();
    ArrayList<String> activecourses2 =new ArrayList<String>();
    ArrayList<String> activecourses2groups =new ArrayList<String>();
    ArrayList<String> coursescodes=new ArrayList<String>();
    ArrayList<String> coursesgroups=new ArrayList<String>();
    ArrayList<String> coursesvaheds=new ArrayList<String>();
    ArrayList<String> coursesnames=new ArrayList<String>();
    ArrayList<String> coursessizes=new ArrayList<String>();
    ArrayList<String> coursesoccupance=new ArrayList<String>();
    ArrayList<String> coursesteachers=new ArrayList<String>();
    ArrayList<String> coursesexamtime=new ArrayList<String>();
    ArrayList<String> coursesschedules=new ArrayList<String>();
    ArrayList<ArrayList<String>> coursesreqiurements=new ArrayList<ArrayList<String>>();
    ArrayList<ArrayList<String>> finalcourses=new ArrayList<ArrayList<String>>();
    ArrayList<String> coursesextrainformations=new ArrayList<String>();

    Filereader() {

        try {
            FileInputStream fin = new FileInputStream("C:\\Users\\Mahan\\Downloads\\Telegram Desktop\\HW.txt");
            int i;
            while ((i = fin.read()) != -1) {
                database += (char) i;
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

        Pattern pattern=Pattern.compile("([^\\s]* [^\\s]*)  ([\\d]{8})  ([^\\s]*)  ([^\\s]* [^\\s]*)  ([^\\s]*( [^\\s]*)?)  ([^\\s]* [^\\s]*)  ([^\\s]*)");
        Matcher matcher=pattern.matcher(database);

        while (matcher.find()) {
            names.add(matcher.group(1));
            users.add(matcher.group(2));
            passwords.add(matcher.group(3));
            majors.add(matcher.group(4));
            orientations.add(matcher.group(5));
            supervisers.add(matcher.group(7));
            activecourses.add(matcher.group(8));
        }

        Pattern pattern2=Pattern.compile("([\\d]{5})  ([\\d]*)  ([\\d]*)  ([^\\s]*)  (.*)  ([\\d]*)  ([\\d]*)  ([^\\s]* [^\\s]*)  ([\\d]+/[\\d]+/[\\d]+)  ([^\\s]*)  ([^\\n]*)[\\n]");
        Matcher matcher2=pattern2.matcher(database);

        while(matcher2.find()){
            coursescodes.add(matcher2.group(1));
            coursesgroups.add(matcher2.group(2));
            coursesvaheds.add(matcher2.group(3));
            coursesnames.add(matcher2.group(5));
            coursesoccupance.add(matcher2.group(6));
            coursessizes.add(matcher2.group(7));
            coursesteachers.add(matcher2.group(8));
            coursesexamtime.add(matcher2.group(9));
            coursesschedules.add(matcher2.group(10));
            if (matcher2.group(11).equals("nan ")){
                coursesextrainformations.add("");
            }
            else {
                coursesextrainformations.add(matcher2.group(11));
            }
            Pattern pattern3=Pattern.compile("[\\d]{5}");
            Matcher matcher3=pattern3.matcher(matcher2.group(4));
            ArrayList<String> temp=new ArrayList<String>();
            while (matcher3.find()){
                temp.add(matcher3.group());
            }
            coursesreqiurements.add(temp);
        }
        System.out.println(coursesschedules);
        System.out.println(coursesextrainformations);
        System.out.println(coursesnames);
        System.out.println(coursescodes);
        System.out.println(coursesgroups);
        System.out.println(coursesvaheds);
    }
}
