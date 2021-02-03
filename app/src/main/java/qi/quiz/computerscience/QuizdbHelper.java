package qi.quiz.computerscience;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class QuizdbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "GoQuiz.db";
    private static final int DATBASE_VERSION = 12;

    private SQLiteDatabase db;


    QuizdbHelper(Context context) {
        super(context, DATABASE_NAME,null, DATBASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionContract.QuestionTable.TABLE_NAME + " ( " +
                QuestionContract.QuestionTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionContract.QuestionTable.COLUMN_QUESTION + " TEXT, " +
                QuestionContract.QuestionTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionContract.QuestionTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionContract.QuestionTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionContract.QuestionTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionContract.QuestionTable.COLUMN_ANSWER_NR + " INTEGER, " +
                QuestionContract.QuestionTable.COLUMN_CATEGORY + " TEXT"+
                ");";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        remplirQuestion();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + QuestionContract.QuestionTable.TABLE_NAME);
        onCreate(db);

    }
    private void remplirQuestion()
    {
        Questions q1 = new Questions("Which of the following statements should" +
                " be used to obtain a remainder after dividing 3.14 by 2.1 ?",
                "rem = 3.14 % 2.1;",
                "rem = modf(3.14, 2.1);",
                "Nothing is correct",
                "rem = fmod(3.14, 2.1);",4,
                Questions.CATEGORY_1);
        addQuestions(q1);

        Questions q2 = new Questions("Which of the following special symbol allowed in a variable name?",
                "* (asterisk)",
                "| (pipeline)",
                " - (hyphen)",
                " _ (underscore)",4,
                Questions.CATEGORY_1);
        addQuestions(q2);

        Questions q3 = new Questions("How would you round off a value from 1.66 to 2.0?",
                "ceil(1.66)",
                "floor(1.66)",
                "roundup(1.66)",
                "roundto(1.66)",1,
                Questions.CATEGORY_1);
        addQuestions(q3);

        Questions q4 = new Questions("What is a library: A file..?",
                "containing ready-made functions",
                "to display text on the screen",
                "A collection of header files",
                "a and c",4,
                Questions.CATEGORY_1);
        addQuestions(q4);

        Questions q5 = new Questions("What does the following code give: &A?",
                "The address of var A",
                "The value of var A",
                "The value of the var pointed to by A",
                "None of above",3,
                Questions.CATEGORY_1);
        addQuestions(q5);

        Questions q6 = new Questions("Which of its codes creates an array of 5 integers?",
                "int Tab(5);",
                "int *Tab[5];",
                "int Tab[4];",
                "int Tab [5];",
                4,Questions.CATEGORY_1);
        addQuestions(q6);

        Questions q7 = new Questions("What is a character string?",
                "A char variable",
                "Array of char",
                "Array of int",
                "Array of long",2,
                Questions.CATEGORY_1);
        addQuestions(q7);

        Questions q8 = new Questions("How to enter a character string (declared by: char String [100])?",
                "scanf (\"%c\" , chaine);",
                "scanf (\"%s\" , chaine);",
                "scanf (\"%c\" ,&chaine);",
                "scanf (\"%s\" , &chaine);",
                2,Questions.CATEGORY_1);
        addQuestions(q8);

        Questions q9 = new Questions("In which header file is the NULL macro defined?",
                "stdio.h",
                "stddef.h",
                "stdio.h and stddef.h",
                "math.h",
                3,Questions.CATEGORY_1);
        addQuestions(q9);

        Questions q10 = new Questions("How to initialize a pointer on an array of 10 chars?",
                "p = malloc (10);",
                "p = (char *) malloc(10,1);",
                "p = (char *) malloc (sizeof(10*char));",
                "p = (char *) malloc(10*sizeof(char));",
                4,Questions.CATEGORY_1);
        addQuestions(q10);

        Questions q11= new Questions("What is (void*)0?",
                "Representation of NULL pointer",
                "Representation of void pointer",
                "Error",
                "None of above",
                1,Questions.CATEGORY_1);
        addQuestions(q11);

        /*Questions q12 = new Questions("What do the 'c' and 'v' in argv stands for?",
                "a. 'c' means argument control 'v' means argument vector",
                "b. 'c' means argument count 'v' means argument vertex",
                "c. 'c' means argument count 'v' means argument vector",
                "d. 'c' means argument configuration 'v' means argument visibility",
                3,Questions.CATEGORY_1);
        addQuestions(q12);*/

        Questions q13 = new Questions("In C, if you pass an array as an "+"" +
                "argument to a function, what actually gets passed?",
                "Value of elements in array",
                "First element of the array",
                "Base address of the array",
                "Address of the last element of array",
                3,Questions.CATEGORY_1);
        addQuestions(q13);

        Questions q14 = new Questions("How will you free the allocated memory ?",
                "remove(var-name);",
                "free(var-name);",
                "delete(var-name);",
                "dalloc(var-name);",
                2,Questions.CATEGORY_1);
        addQuestions(q14);

        Questions q15 = new Questions("What is the similarity between" +
                " a structure, union and enumeration?",
                "let you define new values",
                "let you define new data types",
                "let you define new pointers",
                "let you define new structures",
                2,Questions.CATEGORY_1);
        addQuestions(q15);

        Questions q16 = new Questions("In C programming, which sign do we use for the assignment?",
                " =",
                " :=",
                " ==",
                " None of above",
                3,Questions.CATEGORY_1);
        addQuestions(q16);

        Questions q17 = new Questions("If the number of iterations is known, it is advisable to use:",
                "while …",
                "do … while",
                "for …",
                "All of above",
                1,Questions.CATEGORY_1);
        addQuestions(q17);

        Questions q18 = new Questions("What are the different types of real data type in C ?",
                "float, double",
                "short int, double, long int",
                "float, double, long double",
                "double, long int, float",
                3,Questions.CATEGORY_1);
        addQuestions(q18);

        Questions q19 = new Questions("Which bitwise operator is suitable for\n"
                +"turning off a particular bit in a number?",
                " && operator",
                " & operator",
                " || operator",
                " ! operator",
                2,Questions.CATEGORY_1);
        addQuestions(q19);

        Questions q20 = new Questions(" FILE *fp;\n" +
                                                "fp = fopen(\"NOTES.TXT\", \"r+\");",
                "Reading",
                "Writing",
                "Appending",
                "Read and Write",
                4,Questions.CATEGORY_1);
        addQuestions(q20);

        Questions q21 = new Questions("Which is the right way to declare constant in C?",
                "int constant var =10;",
                "int const var = 10;",
                "const int var = 10;",
                "B & C Both",
                4,Questions.CATEGORY_1);
        addQuestions(q21);

        Questions q22 = new Questions(" Queue is a ______ list.",
                "LIFO",
                "LILO",
                "FILO",
                "FIFO",
                4,Questions.CATEGORY_1);
        addQuestions(q22);

        Questions q23 = new Questions("What will be the output of the following statements?" +
                                                 "int i = 3;" +
                                                 "printf(\"%d%d\",i,i++);",
                "34",
                "43",
                "44",
                "33",
                2,Questions.CATEGORY_1);
        addQuestions(q23);

        Questions q24 = new Questions("int y[4] = {6, 7, 8, 9};\n" +
                "int *ptr = y + 2; printf(\"%d\\n\", ptr[ 1 ] );\n" +
                "What is printed when the sample code above is executed?",
                "6",
                "7",
                "8",
                "9",
                4,Questions.CATEGORY_1);
        addQuestions(q24);

        Questions q25 = new Questions("In switch statement, each case instance value must be __?",
                "Constant",
                "Variable",
                "Special Symbol",
                "None of the avobe",
                1,Questions.CATEGORY_1);
        addQuestions(q25);

  /*      Questions q26 = new Questions("What is the right way to access value" +
                "of structure variable book{ price, page }?",
                "printf(\"%d%d\",book.price, book.page);",
                "printf(\"%d%d\",price.book, page.book);",
                "printf(\"%d%d\",price::book, page::book);",
                "printf(\"%d%d\",price->book, page->book);",
                1,Questions.CATEGORY_1);
        addQuestions(q26);
*/
        //Questions for Category_2 JAVA programming

        Questions q_j1 = new Questions("public class Test { }\n" +
                "What is the prototype of the default constructor?",
                "Test( )",
                "Test(void)",
                "public Test( )",
                "public Test(void)",
                3,Questions.CATEGORY_2);
        addQuestions(q_j1);

        Questions q_j2 = new Questions("Java is a language",
                "Compiled",
                "Interpreter",
                "Compiled and interpreted",
                "Neither compiled nor interpreted",
                3,Questions.CATEGORY_2);
        addQuestions(q_j2);

        Questions q_j3 = new Questions("Java is a language developed by",
                "Hewlett-Packard",
                "Sun Microsystems",
                "Microsoft",
                "Oracle",
                2,Questions.CATEGORY_2);
        addQuestions(q_j3);

        Questions q_j4 = new Questions("How many instances of class A creates the following code?\n" +
                                                "A x,u,v;" +
                                                "x=new A();" +
                                                "A y=x;" +
                                                 "A z=new A()?",
                "Any",
                "Five",
                "Three",
                "two",
                4,Questions.CATEGORY_2);
        addQuestions(q_j4);

       /* Questions q_j5 = new Questions("For class B defined as follows:\n" +
                "class B {\n" +
                "public B(){System.out.print(”Ciao”);};\n" +
                "public B(int i) {this(); System.out.println(”Bonjour ”+i);}}\n"
                +"what will the following instruction display\n?" + "B monB=new B(2003);",
                "a. compilation error",
                "b. runtime error",
                "c. CiaoBonjour 2003",
                "d. Bonjour 2003",
                3,Questions.CATEGORY_2);
        addQuestions(q_j5);*/

        Questions q_j6 = new Questions("Late binding is essential to ensure",
                "encapsulation",
                "polymorphism",
                "Heritage",
                "marginalization",
                2,Questions.CATEGORY_2);
        addQuestions(q_j6);

   /*     Questions q_j7 = new Questions("Which constructs an anonymous inner class instance?",
                "Runnable r =new Runnable(){};",
                "Runnable r =new Runnable(public void run(){});",
                "Runnable r =new Runnable {public void run(){}};",
                "Syso(new Runnable(){public void run(){}});",
                4,Questions.CATEGORY_2);
        addQuestions(q_j7);*/

        Questions q_j8 = new Questions("Which is true about a method-local inner class?",
                "It must be marked final.",
                "It can be marked abstract.",
                "It can be marked public.",
                "It can be marked static.",
                2,Questions.CATEGORY_2);
        addQuestions(q_j8);

        /*Questions q_j9 = new Questions("Which statement is true about a static nested class?",
                "a. It does not have access to nonstatic members of the enclosing class.",
                "b. It's variables and methods must be static.",
                "c. It must extend the enclosing class.",
                "d. None of above",
                1,Questions.CATEGORY_2);
        addQuestions(q_j9);*/

        Questions q_j10 = new Questions("Which interface does java.util.Hashtable implement?",
                "Java.util.Map",
                "Java.util.List",
                "Java.util.HashTable",
                "Java.util.Collection",
                1,Questions.CATEGORY_2);
        addQuestions(q_j10);

        Questions q_j11 = new Questions("What is the numerical range of char?",
                "0 to 32767",
                "0 to 65535",
                "-256 to 255",
                "d. -32768 to 32767",
                2,Questions.CATEGORY_2);
        addQuestions(q_j11);

        Questions q_j12 = new Questions("Which interface provides the capability"
                                              +"to store objects using a key-value pair?",
                "Java.util.Map",
                "Java.util.Set",
                "Java.util.List",
                "Java.util.Collection",
                1,Questions.CATEGORY_2);
        addQuestions(q_j12);

        Questions q_j13 = new Questions("public class Foo {\n" +
                "public static void main(String[] args){ \n" +
                "try {" +
                "return; }" +
                "finally {" +
                "System.out.println( \"Finally\" ); }}}",
                "Finally",
                "Compilation fails.",
                "The code runs with no output.",
                "An exception is thrown at runtime.",
                1,Questions.CATEGORY_2);
        addQuestions(q_j13);

        Questions q_j14 = new Questions("What are the different types of Bean injections?",
                "constructor and setter",
                "constructor and getter",
                "getter ans setter",
                "setter, getter and constructor",
                1,Questions.CATEGORY_2);
        addQuestions(q_j14);

     /*   Questions q_j15 = new Questions("Which of the following statements"
                                                +"is correct regarding the Spring Framework?",
                "a. The Framework Spring is a heavy-weight solution.",
                "b. The Framework Spring is a light-weight solution.",
                "c. Both a and b are true.",
                "d. None of these answers is true.",
                2,Questions.CATEGORY_2);
        addQuestions(q_j15);*/

        Questions q_j16 = new Questions("Java programs are interpreted by",
                "API",
                "JDK",
                "JVM",
                "AWT",
                3,Questions.CATEGORY_2);
        addQuestions(q_j16);

        Questions q_j17 = new Questions("Which of the above operations is prohibited in Java?",
                "implicit upcasting",
                "explicit upcasting",
                "implicit downcasting",
                "explicit downcasting",
                3,Questions.CATEGORY_2);
        addQuestions(q_j17);

        Questions q_j18 = new Questions("Which class has no mother class?",
                "Orpheline",
                "String",
                "Object",
                "an abstract class",
                3,Questions.CATEGORY_2);
        addQuestions(q_j18);

        Questions q_j19 = new Questions("What is wrong with interfaces?",
                "An I. can be the type of a reference",
                "An I. can be implemented",
                "An I. can be instantiated",
                "None of the above",
                3,Questions.CATEGORY_2);
        addQuestions(q_j19);

      /*  Questions q_j20 = new Questions("For the class defined as follows:\n"
                +"public class Bidon {int x ;} ;\n"
                +"which of the programs is wrong?",
                "a. Bidon a=new Bidon(3) ;",
                "b. Bidon a=new Bidon(); String s=a.toString();",
                "c. Bidon a=new Bidon(); boolean b= a.equals(”foo”);",
                "d. Bidon a=new Bidon(); boolean b= a.equals(a);",
                1,Questions.CATEGORY_2);
        addQuestions(q_j20);*/

        Questions q_21 = new Questions("When is method overload determined?",
                "At the time of execution",
                "At the time of compilation",
                "At the time of coding",
                "None of above",
                2,Questions.CATEGORY_2);
        addQuestions(q_21);

        Questions q_22 = new Questions("What concept of Java is used when\n"+
                "combining methods and attributes in a class?",
                "Polymorphism",
                "Encapsulation",
                "Abstraction",
                "Heritage",
                2,Questions.CATEGORY_2);
        addQuestions(q_22);

        Questions q_23 = new Questions("What keywords are used to specify\n"
                +" the visibility of properties and methods?",
                "public",
                "private",
                "protected",
                "All of above",
                4,Questions.CATEGORY_2);
        addQuestions(q_23);

        Questions q_j24 = new Questions("To specify that the value of a variable cannot change,\n"
                +" we declare it as a constant with the reserved word:",
                "finalize",
                "const",
                "define",
                "final",
                4,Questions.CATEGORY_2);
        addQuestions(q_j24);

        Questions q_j25 = new Questions("java.util.Collections is a:",
                "Class",
                "Interface",
                "Object",
                "None of the above",
                1,Questions.CATEGORY_2);
        addQuestions(q_j25);

        Questions q_j26 = new Questions("Which of those allows duplicate elements?",
                "Set",
                "List",
                "All",
                "None of above",
                2,Questions.CATEGORY_2);
        addQuestions(q_j26);

        Questions q_j27 = new Questions("Which interface should be implemented for sorting on basis of many criteria’s?",
                "Comparator",
                "Comparable",
                "Serializable",
                "None of the above",
                1,Questions.CATEGORY_2);
        addQuestions(q_j27);

        Questions q_j28 = new Questions("Which of those doesn't have an index based structure?",
                "List",
                "Set",
                "Map",
                "None of above",
                2,Questions.CATEGORY_2);
        addQuestions(q_j28);

        //Questions for Category_3 C++ programming

        Questions q_c1 = new Questions("How to access the object in the class?",
                "scope resolution operator",
                "ternary operator",
                "direct member access operator",
                "resolution operator",
                3,Questions.CATEGORY_3);
        addQuestions(q_c1);

        Questions q_c2 = new Questions("An expression A.B in C++ means ___",
                "A is member of object B",
                "B is member of Object A",
                "Product of A and B",
                "None of above",
                2,Questions.CATEGORY_3);
        addQuestions(q_c2);

        Questions q_c3 = new Questions("Which class allows only one object to be created.",
                "Nuclear Family Class",
                "Sigleton Class",
                "Abstruct Class",
                "Numero Uno Class",
                3,Questions.CATEGORY_3);
        addQuestions(q_c3);

        Questions q_c4 = new Questions("Delaration a pointer more than once may cause __",
                "Error",
                "Trap",
                "Abort",
                "Null",
                2,Questions.CATEGORY_3);
        addQuestions(q_c4);

        Questions q_c5 = new Questions("To perfor file input / output operation in C++,\n"
                +" we must include which header file ?",
                "<fiostream>",
                "<ifstream>",
                "<ofstream>",
                "<fstream>",
                4,Questions.CATEGORY_3);
        addQuestions(q_c5);

        Questions q_c6 = new Questions("An exceptio in C++ can be generated using which keywords.",
                "thrown",
                "threw",
                "throw",
                "throws",
                3,Questions.CATEGORY_3);
        addQuestions(q_c6);

        Questions q_c7 = new Questions("In CPP, members of a class are ______ by default.",
                "Public",
                "Private",
                "Protected",
                "Static",
                2,Questions.CATEGORY_3);
        addQuestions(q_c7);

        Questions q_c8 = new Questions("Reusability of code in C++ is achieved through ____",
                "Polymorphism",
                "Inheritance",
                "Encapsulation",
                "Both a and b",
                2,Questions.CATEGORY_3);
        addQuestions(q_c8);

        Questions q_c9 = new Questions("Where does the execution of the program starts?",
                "user-defined function",
                "void function",
                "main function",
                "none of the mentioned",
                2,Questions.CATEGORY_3);
        addQuestions(q_c9);

        Questions q_c10 = new Questions("What is the correct syntax to declare\n"
                +" an integer variable dynamically in C++ programming language?",
                "int *ival = new int(10);",
                "int ival = new int (10);",
                "Both (a) and (b)",
                "None of above",
                1,Questions.CATEGORY_3);
        addQuestions(q_c10);

        Questions q_c11 = new Questions("What is the correct syntax for accessing a static member of a class?\n"
                +"class A" +
                "{" +
                "  public:" +
                "    static int val;" +
                "}",
                "A->val",

                "A.val",
                "A::val",
                "A^val",
                3,Questions.CATEGORY_3);
        addQuestions(q_c11);

        Questions q_c12 = new Questions("C ++ is a language:",
                "procedural",
                "functional",
                "to objects",
                "None of above",
                3,Questions.CATEGORY_3);
        addQuestions(q_c12);

        Questions q_c13 = new Questions("In C ++, the declaration of a class:",
                "can contain 0 or more constructors",
                "must always contain 2 constructors",
                "should only contain 1 constructors",
                "must contain at least 1 constructors",
                1,Questions.CATEGORY_3);
        addQuestions(q_c13);

        Questions q_c14 = new Questions("In C ++, the C prototype C :: operator- (C & c) const returns:",
                "this=this-c",
                "this+(-c)",
                "this-c",
                "this-*c",
                3,Questions.CATEGORY_3);
        addQuestions(q_c14);

        Questions q_c15 = new Questions("In C ++, the new operator allows you to:",
                "create a dynamically allocated object",
                "define a dynamically allocated type",
                "define a new class",
                "to initialize a new type",
                1,Questions.CATEGORY_3);
        addQuestions(q_c15);

        Questions q_c16 = new Questions("In C ++, the statement delete [] p;",
                "del the first element from the array p",
                "declare an array p of type delete",
                "Deallocate storage space of array p",
                "remove variable p",
                3,Questions.CATEGORY_3);
        addQuestions(q_c16);

        Questions q_c17 = new Questions("How many arguments can a destructor of a class receive?",
                "0",
                "1",
                "2",
                "None of above",
                1,Questions.CATEGORY_3);
        addQuestions(q_c17);

        Questions q_c18 = new Questions("What is the result of the following program:\n"+
                "#include<iostream>" +
                "using namespace std;" +
                "main()" +
                "{ char s[] = \"hello\"," +
                "t[] = \"hello\";" +
                "if(s==t) cout<<\"eqaul strings\";" +
                "}",
                "equal strings",
                "strings",
                "No output",
                "Compile error",
                3,Questions.CATEGORY_3);
        addQuestions(q_c18);

        Questions q_c19 = new Questions("What is the result of the following program?\n"+
                "#include <iostream>" +
                "void f(float) { std::cout << 1; }" +
                "void f(double) { std::cout << 2; }" +
                "int main() {" +
                "f(2.5);" +
                "f(2.5f);" +
                "}",
                "Compile error",
                "12",
                "21",
                "Nothing",
                3,Questions.CATEGORY_3);
        addQuestions(q_c19);

        Questions q_c20 = new Questions("What is the value of the local variable x at the end of the hand?\n"+
                "int x = 5;" +
                "int main(int argc, char** argv) {" +
                "    int x = x;" +
                "    return 0; }",
                "0",
                "5",
                "Not defined",
                "None of above",
                3,Questions.CATEGORY_3);
        addQuestions(q_c20);

        Questions q_c21 = new Questions("What is the value of y at the end of main?\n"+
                "const int x = 5;" +
                "int main(int argc, char** argv) {" +
                "    int x[x];" +
                "    int y = sizeof(x) / sizeof(int);" +
                "    return 0; }",
                "a. 0",
                "b. 5",
                "c. 20",
                "d. Not defined",
                2,Questions.CATEGORY_3);
        addQuestions(q_c21);

        // Questions for Category_4 Networking

        Questions q_n1 = new Questions("What protocol works at the transport\n" +
                "layer providing connectionless service between hosts?",
                "UDP",
                "TCP",
                "ARP",
                "IP",
                1,Questions.CATEGORY_4);
        addQuestions(q_n1);

        Questions q_n2 = new Questions("What address range can be used in the first\n"
                +" byte of a class B network address?",
                "1-126",
                "128-190",
                "128-191",
                "192-220",
                3,Questions.CATEGORY_4);
        addQuestions(q_n2);

        Questions q_n3 = new Questions("What protocol works at the transport layer\n"+
                " and provides virtual circuits between hosts?",
                "TCP",
                "UDP",
                "ARP",
                "IP",
                1,Questions.CATEGORY_4);
        addQuestions(q_n3);

        Questions q_n4 = new Questions("What protocol is used to find the MAC address of a local device?",
                "ICMP",
                "IP",
                "ARP",
                "RARP",
                3,Questions.CATEGORY_4);
        addQuestions(q_n4);

        Questions q_n5 = new Questions("How many bytes are required to encode an Ethernet address?",
                "4",
                "6",
                "8",
                "16",
                2,Questions.CATEGORY_4);
        addQuestions(q_n5);

        Questions q_n6 = new Questions("What is the valid host range of which the IP address\n"
                +" 172.16.10.22 / 255.255.255.240 is a part?",
                "172.16.10.20 à 172.16.10.22",
                "172.16.10.1 à 172.16.10.255",
                "172.16.10.16 à 172.16.10.23",
                "172.16.10.17 à 172.16.10.30",
                4,Questions.CATEGORY_4);
        addQuestions(q_n6);

        Questions q_n7 = new Questions("What protocol works at the Internet layer\n"
                +" and provides connection service between hosts?",
                "TCP",
                "UDP",
                "ARP",
                "IP",
                4,Questions.CATEGORY_4);
        addQuestions(q_n7);

        Questions q_n8 = new Questions("Which of the following is not a type of computer network??",
                "Local Area Network (LAN)",
                "Personal Area Network (PAN)",
                "Remote Area Network (RAN)",
                "Metropolitan Area Network (MAN)",
                3,Questions.CATEGORY_4);
        addQuestions(q_n8);

        Questions q_n9 = new Questions("Which of the following types of cables is twisted pair?",
                "Câble coaxial",
                "Shielded twisted pair (STP)",
                "Unshielded Twisted Pair (UTP)",
                "Both b and c are true.",
                4,Questions.CATEGORY_4);
        addQuestions(q_n9);

        Questions q_n10 = new Questions("What is the full form of NIC?",
                "Net Interface Card",
                "Network Interface Card",
                "Network Interface Connection",
                "New Internet Connection)",
                2,Questions.CATEGORY_4);
        addQuestions(q_n10);

        Questions q_n11 = new Questions("TCP / IP is also known as ___?",
                "OSI model",
                "TCP model",
                "DOD model",
                "Network model",
                3,Questions.CATEGORY_4);
        addQuestions(q_n11);

        Questions q_n12 = new Questions("The star topology is based on a central device can be a ___?",
                "HUB",
                "Switch",
                "Both a and b are true",
                "None of these answers is true",
                3,Questions.CATEGORY_4);
        addQuestions(q_n12);

        Questions q_n13 = new Questions("The Switch is a device of the __ of the OSI model",
                "Network layer",
                "Data link layer",
                "Application layer",
                "Session layer",
                2,Questions.CATEGORY_4);
        addQuestions(q_n13);

        Questions q_n14 = new Questions("HUB is a device _________?",
                "Unicast",
                "Multicast",
                "Broadcast",
                "None of these answers is true.",
                3,Questions.CATEGORY_4);
        addQuestions(q_n14);

        Questions q_n15 = new Questions("Switch is a _________ device?",
                "Unicast",
                "Multicast",
                "Broadcast",
                "None of these answers is true.",
                1,Questions.CATEGORY_4);
        addQuestions(q_n15);

        Questions q_n16 = new Questions("What type of cable is used to connect similar devices?",
                "Straight cable",
                "Crossover cable",
                "Serial cable",
                "All the answers are true",
                2,Questions.CATEGORY_4);
        addQuestions(q_n16);

        Questions q_n17 = new Questions("The domain __ is used to associate an address with a domain name.",
                "generic",
                "national",
                "inverted",
                "None of above",
                3,Questions.CATEGORY_4);
        addQuestions(q_n17);

        Questions q_n18 = new Questions("In resolution _, the server returns the IP address of the server which it believes can resolve the request.",
                "generic",
                "national",
                "inverted",
                "None of above",
                1,Questions.CATEGORY_4);
        addQuestions(q_n18);

        Questions q_n19 = new Questions("In resolution __, the resolver expects the server to provide the final response.",
                "iterative",
                "recursive",
                "normal",
                "None of above",
                2,Questions.CATEGORY_4);
        addQuestions(q_n19);

        Questions q_n20 = new Questions("When a collection of multiple computers make up a coherent system, we call that, a __?",
                "computer network",
                "distributed system",
                "network system",
                "None of above",
                2,Questions.CATEGORY_4);
        addQuestions(q_n20);

        Questions q_n21 = new Questions("The __ OSI layer establishes and manages transmissions between computers.",
                "Physical",
                "Application",
                "Session",
                "Presentation",
                3,Questions.CATEGORY_4);
        addQuestions(q_n21);

        Questions q_n22 = new Questions("The two catagories of network operating systems are:",
                "point-to-point and client-server",
                "point-to-point and round-about",
                "peer-to-peer and doesy-doe",
                "peer-to-peer and client-server.",
                4,Questions.CATEGORY_4);
        addQuestions(q_n22);

     /*  Questions q_n24 = new Questions("What does TCP/IP stand for?",
                "Transport Control Protocol/Interaction Protocol",
                "Terminal Control Protocol/Internet Protocol",
                "Transport Control Protocol/Interwork Protocol",
                "Transmission Control Protocol/Internet Protocol",
                4,Questions.CATEGORY_4);
        addQuestions(q_n24);*/

        Questions q_n25 = new Questions("The __ topology typically uses more cable than other network topologies.",
                "ring",
                "bus",
                "star",
                "hybrid",
                3,Questions.CATEGORY_4);
        addQuestions(q_n25);

       // Questions for Category_5 Linux

        Questions q_l1 = new Questions("General purpose UNIX command are found typically in the following directory.",
                "/dev",
                "/sbin",
                "/bin and /usr/bin",
                "/tmp",
                3,Questions.CATEGORY_5);
        addQuestions(q_l1);

        Questions q_l2 = new Questions("Applications communicate with the kernel using… ..?",
                "The shell",
                "The shell script",
                "A C program",
                "System calls",
                4,Questions.CATEGORY_5);
        addQuestions(q_l2);

        Questions q_l3 = new Questions("Choose the option to remove write permission for group & others for a file “a.txt”.",
                "chmod go-w a.txt",
                "chmod w-go a.txt",
                "chmod go=”r-x” a.txt",
                "None of above",
                2,Questions.CATEGORY_5);
        addQuestions(q_l3);

        Questions q_l4 = new Questions("Ubuntu is based on…",
                "Fedora",
                "Slackware",
                "Debian",
                "None of above",
                3,Questions.CATEGORY_5);
        addQuestions(q_l4);

        Questions q_l5 = new Questions("‘mkfs’ is used to:",
                "create a filesystem on a device",
                "format a floppy disk",
                "create a fast changing section",
                "create a named pipe (fifo) on a device",
                1,Questions.CATEGORY_5);
        addQuestions(q_l5);

        Questions q_l6 = new Questions("SSH stands for _____.",
                "Security Shell",
                "Synchronous Shell",
                "System Shell",
                "Secure Shell",
                4,Questions.CATEGORY_5);
        addQuestions(q_l6);

        Questions q_l7 = new Questions("What does it means when the ps commands\n"
                +" shows a ‘Z’ in the status column for a process? Thr process is..",
                "is in sleep mode.",
                "is running at top priority",
                "is a zombie process.",
                "is running at low priority.",
                3,Questions.CATEGORY_5);
        addQuestions(q_l7);

        Questions q_l8 = new Questions("The netstat command give information on:",
                "all are correct",
                "active sockets",
                "open sockets",
                "routing tables",
                1,Questions.CATEGORY_5);
        addQuestions(q_l8);

        Questions q_l9 = new Questions("To repeat the last command in the bash shell history, type…",
                "!!",
                "$HISTFILE",
                "!6",
                "None of above",
                1,Questions.CATEGORY_5);
        addQuestions(q_l9);

      /*  Questions q_l10 = new Questions("What is swap?",
                "Swap is used when the amount of (RAM) is full",
                "Swap is the cache of your HDD",
                "Swap is the cache of your Physical Memory (RAM)",
                "None of above",
                1,Questions.CATEGORY_5);
        addQuestions(q_l10);*/

        Questions q_l11 = new Questions("To query DNS servers, you use the command:",
                "dns",
                "lsrouted",
                "dnsquery",
                "nslookup",
                4,Questions.CATEGORY_5);
        addQuestions(q_l11);

        Questions q_l12 = new Questions("Add this symbol to a command to run it in the background",
                " &",
                " *",
                " $",
                " ?",
                1,Questions.CATEGORY_5);
        addQuestions(q_l12);

        Questions q_l13 = new Questions("LILO…",
                "is a boot loader that can boot Linux",
                "stands for “Lannister-In-Lannister-Out”",
                "is only used by Slackware",
                "stands for “Light Loader”",
                1,Questions.CATEGORY_5);
        addQuestions(q_l13);

        Questions q_l14 = new Questions("uname -a will output…",
                "a. kernel and cpu info",
                "b. architecture",
                "c. date where the kernel was built",
                "d. All of the answers are correct.",
                4,Questions.CATEGORY_5);
        addQuestions(q_l14);

        Questions q_l15 = new Questions("Which tool is similar to find except that it uses an index to search?",
                "locate",
                "fastfind",
                "search",
                "None of above",
                1,Questions.CATEGORY_5);
        addQuestions(q_l15);

        Questions q_l16 = new Questions("To read one or more files and type them on standard output, you use?",
                "ls",
                "cat",
                "type",
                "biff",
                2,Questions.CATEGORY_5);
        addQuestions(q_l16);

        /*Questions q_l17 = new Questions("What is a zombie process?",
                "a. A zombie process is a process created by a worm to remain active even after it is killed.",
                "b. A zombie process is a process which has terminated, but whose parent had not yet read its exit status.",
                "c. A zombie process is a process whose status had been saved on the disk, and which is now waiting to be restored.",
                "d. None of above",
                2,Questions.CATEGORY_5);
        addQuestions(q_l17);*/

        Questions q_l18 = new Questions("How would you create an alias for the cat command?",
                "alias bkw=cat",
                "You cannot do that.",
                "ren bkw=cat",
                "None of above",
                1,Questions.CATEGORY_5);
        addQuestions(q_l18);

        Questions q_l19 = new Questions("How to reveal detailed information about CPU?",
                "sysinfo –cpu",
                "cpusage",
                "dmesg",
                "cat /proc/cpuinfo",
                4,Questions.CATEGORY_5);
        addQuestions(q_l19);

        Questions q_l20 = new Questions("lsof command means:",
                "Large Scale Optimization File",
                "List Open Files",
                "Local System Officer",
                "Local Service of Files",
                2,Questions.CATEGORY_5);
        addQuestions(q_l20);

       /* Questions q_l21 = new Questions("Which of the following accurately describes a “ping?”",
                "a. sends ICMP packets to target device/server to verify if it’s online.",
                "b. makes an audiable ping each time a disk drive start spinning",
                "c. verifies that the routing tables comply to the current network state",
                "d. sends TCP packets to target device/server to verify if it’s online.",
                1,Questions.CATEGORY_5);
        addQuestions(q_l21);*/

        Questions q_l22 = new Questions("When does /tmp normally get cleaned out?",
                "Never; it has to be manually cleaned",
                "Every time the system is booted",
                "Every week (run by /etc/cron.weekly)",
                "None of above",
                2,Questions.CATEGORY_5);
        addQuestions(q_l22);

        Questions q_l23 = new Questions("To report the amount of free disk space available\n"
                                                +"on all mounted file systems you use the command:",
                "free",
                "fs",
                "fs",
                "df",
                4,Questions.CATEGORY_5);
        addQuestions(q_l23);

      /*  Questions q_l24 = new Questions("printenv will:",
                "a. print a text file to the printer specified in /etc/env",
                "b. print a text file to the printer specified in $PRINTER",
                "c. type values of environment variables",
                "d. print a text file to the default printer",
                3,Questions.CATEGORY_5);
        addQuestions(q_l24);
       */

        Questions q_l25 = new Questions("Write a command to list all files with 5 characters in the name.",
                "ls !!!!!",
                "ls ?????",
                "ls *****",
                "None of above",
                2,Questions.CATEGORY_5);
        addQuestions(q_l25);

        Questions q_l26 = new Questions("What binary format do Linux Executables use?",
                "PE",
                "ELF",
                "Mach-O",
                "a.out",
                2,Questions.CATEGORY_5);
        addQuestions(q_l26);

        Questions q_l27 = new Questions("What is the uid of root?",
                "superuser",
                "o",
                "1000",
                "None of above",
                2,Questions.CATEGORY_5);
        addQuestions(q_l27);

        Questions q_l28 = new Questions("SSH uses _____ to authenticate remote computers.",
                "public key cryptography",
                "secret key cryptography",
                "both block and stream ciphers",
                "stream cipher",
                1,Questions.CATEGORY_5);
        addQuestions(q_l28);

        Questions q_l29 = new Questions("What program is launched by the kernel at system start up first?",
                "/sbin/start",
                "/boot",
                "/etc/rc.d/rc.sysinit",
                "/sbin/init",
                4,Questions.CATEGORY_5);
        addQuestions(q_l29);

        Questions q_l30 = new Questions("In a file delimited by commas, what command will print the 3rd column of data:",
                "awk -f, ‘{print $3}’",
                "awk ‘{print $3}’",
                "awk -F, ‘{print $3}’",
                "None of above",
                3,Questions.CATEGORY_5);
        addQuestions(q_l30);

        Questions q_l31 = new Questions("Which one of these lines will check if the directory\n"
                +" “toto” exists and create it if it doesn’t?",
                "mkdir -p toto",
                "test -d toto || mkdir toto",
                "if [ ! -d toto ]; then mkdir toto; fi",
                "All of them",
                4,Questions.CATEGORY_5);
        addQuestions(q_l31);

        Questions q_l32 = new Questions("To format a device as an ext3 (journaled)\n"
                +" Linux extended filesystem, you use the commands:",
                "mkfs.ext3",
                "all are correct",
                "mkfs.ext2 -j",
                "None of above",
                2,Questions.CATEGORY_5);
        addQuestions(q_l32);





    }

    private void addQuestions(Questions question){

        ContentValues cv = new ContentValues();
        cv.put(QuestionContract.QuestionTable.COLUMN_QUESTION,question.getQuestion());
        cv.put(QuestionContract.QuestionTable.COLUMN_OPTION1,question.getOption1());
        cv.put(QuestionContract.QuestionTable.COLUMN_OPTION2,question.getOption2());
        cv.put(QuestionContract.QuestionTable.COLUMN_OPTION3,question.getOption3());
        cv.put(QuestionContract.QuestionTable.COLUMN_OPTION4,question.getOption4());
        cv.put(QuestionContract.QuestionTable.COLUMN_ANSWER_NR,question.getAnswerNext());
        cv.put(QuestionContract.QuestionTable.COLUMN_CATEGORY,question.getCategory());
        db.insert(QuestionContract.QuestionTable.TABLE_NAME,null,cv);
    }
/*
    public ArrayList<Questions> getAllQuestions() {

        ArrayList<Questions> questionList = new ArrayList<>();
        db = getReadableDatabase();


        String Projection[] = {

                QuestionTable._ID,
                QuestionTable.COLUMN_QUESTION,
                QuestionTable.COLUMN_OPTION1,
                QuestionTable.COLUMN_OPTION2,
                QuestionTable.COLUMN_OPTION3,
                QuestionTable.COLUMN_OPTION4,
                QuestionTable.COLUMN_ANSWER_NR
        };



        Cursor c = db.query(QuestionTable.TABLE_NAME,
                Projection,
                null,
                null,
                null,
                null,
                null);


        if (c.moveToFirst()) {
            do {

                Questions question = new Questions();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION4)));
                question.setAnswerNext(c.getInt(c.getColumnIndex(QuestionTable.COLUMN_ANSWER_NR)));

                questionList.add(question);

            } while (c.moveToNext());

        }
        c.close();
        return questionList;
    }
*/
    public ArrayList<Questions> getAllQuestionsWithCategory(String category) {

        ArrayList<Questions> questionList = new ArrayList<>();
        db = getReadableDatabase();


        String Projection[] = {

                QuestionContract.QuestionTable._ID,
                QuestionContract.QuestionTable.COLUMN_QUESTION,
                QuestionContract.QuestionTable.COLUMN_OPTION1,
                QuestionContract.QuestionTable.COLUMN_OPTION2,
                QuestionContract.QuestionTable.COLUMN_OPTION3,
                QuestionContract.QuestionTable.COLUMN_OPTION4,
                QuestionContract.QuestionTable.COLUMN_ANSWER_NR,
                QuestionContract.QuestionTable.COLUMN_CATEGORY
        };

        String selection = QuestionContract.QuestionTable.COLUMN_CATEGORY + " = ? ";
        String selectionArgs[] = { category };

        Cursor c = db.query(QuestionContract.QuestionTable.TABLE_NAME, Projection, selection, selectionArgs, null, null, null);


        if (c.moveToFirst()) {
            do {

                Questions question = new Questions();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionContract.QuestionTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionContract.QuestionTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionContract.QuestionTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionContract.QuestionTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionContract.QuestionTable.COLUMN_OPTION4)));
                question.setAnswerNext(c.getInt(c.getColumnIndex(QuestionContract.QuestionTable.COLUMN_ANSWER_NR)));
                question.setCategory(c.getString(c.getColumnIndex(QuestionContract.QuestionTable.COLUMN_CATEGORY)));
                questionList.add(question);

            } while (c.moveToNext());

        }
        c.close();
        return questionList;
    }
}
