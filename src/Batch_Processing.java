// -- Active: 1707299025167@@127.0.0.1@3306@mydatabase
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class Batch_Processing {
    public static void main(String[] args) throws ClassNotFoundException {
        
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "Root_1234";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loded Successfully");

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try{
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Successfully");
            connection.setAutoCommit(false);
            String query = ("INSERT INTO employees(name, job_title, salary) VALUES (?, ?, ?)");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("Name: " );
                String name = scanner.nextLine();
                System.out.print("job_title: ");
                String job_title = scanner.nextLine();
                System.out.print("salary: ");
                Double salary = scanner.nextDouble();
                scanner.nextLine();

                preparedStatement.setString(1, name);
                preparedStatement.setString(2, job_title);
                preparedStatement.setDouble(3, salary);

                preparedStatement.addBatch();

                System.out.println("Add more Value Y/N: ");
                String decision = scanner.nextLine();

                if(decision.toUpperCase().equals("N")) {
                    break;
                }

            }

            int[] batchResult = preparedStatement.executeBatch();
            connection.commit();
            System.out.println("Batched run sucessfully");

            
            



            // Statement smt = con.createStatement();
            // smt.addBatch("INSERT INTO employees(name, job_title, salary) VALUES('Raja', 'Sql Developer', 38000)");
            // smt.addBatch("INSERT INTO employees(name, job_title, salary) VALUES('Sona', 'AWS Developer', 70000)");
            // smt.addBatch("INSERT INTO employees(name, job_title, salary) VALUES('DBC', 'Oracle Developer', 58000)");

            // int[] batchResult = smt.executeBatch();
            // con.commit();
            // System.out.println("Batch Executed!!!");
            

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }


    }
}


// %-------------------------
// % Resume in Latex
// % Author : Abey George
// % Based off of: https://github.com/sb2nov/resume
// % License : MIT
// %------------------------

// \documentclass[letterpaper,11pt]{article}

// \usepackage{latexsym}
// \usepackage[empty]{fullpage}
// \usepackage{titlesec}
// \usepackage{marvosym}
// \usepackage[usenames,dvipsnames]{color}
// \usepackage{verbatim}
// \usepackage{enumitem}
// \usepackage[hidelinks]{hyperref}
// \usepackage[english]{babel}
// \usepackage{tabularx}
// \usepackage{fontawesome5}
// \usepackage{multicol}
// \usepackage{graphicx}
// \setlength{\multicolsep}{-3.0pt}
// \setlength{\columnsep}{-1pt}
// \input{glyphtounicode}

// \RequirePackage{tikz}
// \RequirePackage{xcolor}
// \RequirePackage{fontawesome}
// \usepackage{tikz}
// \usetikzlibrary{svg.path}


// \definecolor{cvblue}{HTML}{0E5484}
// \definecolor{black}{HTML}{130810}
// \definecolor{darkcolor}{HTML}{0F4539}
// \definecolor{cvgreen}{HTML}{3BD80D}
// \definecolor{taggreen}{HTML}{00E278}
// \definecolor{SlateGrey}{HTML}{2E2E2E}
// \definecolor{LightGrey}{HTML}{666666}
// \colorlet{name}{black}
// \colorlet{tagline}{darkcolor}
// \colorlet{heading}{darkcolor}
// \colorlet{headingrule}{cvblue}
// \colorlet{accent}{darkcolor}
// \colorlet{emphasis}{SlateGrey}
// \colorlet{body}{LightGrey}



// %----------FONT OPTIONS----------
// % sans-serif
// % \usepackage[sfdefault]{FiraSans}
// % \usepackage[sfdefault]{roboto}
// % \usepackage[sfdefault]{noto-sans}
// % \usepackage[default]{sourcesanspro}

// % serif
// % \usepackage{CormorantGaramond}
// % \usepackage{charter}


// % \pagestyle{fancy}
// % \fancyhf{}  % clear all header and footer fields
// % \fancyfoot{}
// % \renewcommand{\headrulewidth}{0pt}
// % \renewcommand{\footrulewidth}{0pt}

// % Adjust margins
// \addtolength{\oddsidemargin}{-0.6in}
// \addtolength{\evensidemargin}{-0.5in}
// \addtolength{\textwidth}{1.19in}
// \addtolength{\topmargin}{-.7in}
// \addtolength{\textheight}{1.4in}

// \urlstyle{same}

// \raggedbottom
// \raggedright
// \setlength{\tabcolsep}{0in}

// % Sections formatting
// \titleformat{\section}{
//   \vspace{-4pt}\scshape\raggedright\large\bfseries
// }{}{0em}{}[\color{black}\titlerule \vspace{-5pt}]

// % Ensure that generate pdf is machine readable/ATS parsable
// \pdfgentounicode=1

// %-------------------------
// % Custom commands
// \newcommand{\resumeItem}[1]{
//   \item\small{
//     {#1 \vspace{-2pt}}
//   }
// }

// \newcommand{\classesList}[4]{
//     \item\small{
//         {#1 #2 #3 #4 \vspace{-2pt}}
//   }
// }

// \newcommand{\resumeSubheading}[4]{
//   \vspace{-2pt}\item
//     \begin{tabular*}{1.0\textwidth}[t]{l@{\extracolsep{\fill}}r}
//       \textbf{\large#1} & \textbf{\small #2} \\
//       \textit{\large#3} & \textit{\small #4} \\
      
//     \end{tabular*}\vspace{-7pt}
// }

// \newcommand{\resumeSubSubheading}[2]{
//     \item
//     \begin{tabular*}{0.97\textwidth}{l@{\extracolsep{\fill}}r}
//       \textit{\small#1} & \textit{\small #2} \\
//     \end{tabular*}\vspace{-7pt}
// }


// \newcommand{\resumeProjectHeading}[2]{
//     \item
//     \begin{tabular*}{1.001\textwidth}{l@{\extracolsep{\fill}}r}
//       \small#1 & \textbf{\small #2}\\
//     \end{tabular*}\vspace{-7pt}
// }

// \newcommand{\resumeSubItem}[1]{\resumeItem{#1}\vspace{-4pt}}

// \renewcommand\labelitemi{$\vcenter{\hbox{\tiny$\bullet$}}$}
// \renewcommand\labelitemii{$\vcenter{\hbox{\tiny$\bullet$}}$}

// \newcommand{\resumeSubHeadingListStart}{\begin{itemize}[leftmargin=0.0in, label={}]}
// \newcommand{\resumeSubHeadingListEnd}{\end{itemize}}
// \newcommand{\resumeItemListStart}{\begin{itemize}}
// \newcommand{\resumeItemListEnd}{\end{itemize}\vspace{-5pt}}


// \newcommand\sbullet[1][.5]{\mathbin{\vcenter{\hbox{\scalebox{#1}{$\bullet$}}}}}

// %-------------------------------------------
// %%%%%%  RESUME STARTS HERE  %%%%%%%%%%%%%%%%%%%%%%%%%%%%


// \begin{document}

// %----------HEADING----------


// \begin{center}
//     {\Huge \scshape SOMNATH KUNDU} \\ \vspace{1pt}
//     KOLKATA :: WEST BENGAL \\ \vspace{1pt}
//     \small \href{tel:+xxxxxxxxxxxx}{ \raisebox{-0.1\height}\faPhone\ \underline{+91-7602359921} ~} \href{mailto:kundusomnath610@gmail.com}{\raisebox{-0.2\height}\faEnvelope\  \underline{kundusomnath610@gmail.com}} ~ 
//      \href{https://www.linkedin.com/in/somnath-kundu/}{\raisebox{-0.2\height}\faLinkedinSquare\ \underline{Linkedin}}  ~
//     \href{https://github.com/kundusomnath610}{\raisebox{-0.2\height}\faGithub\ \underline{Github}} ~
//    \href{https://leetcode.com/kundusomnath610/}{\raisebox{-0.2\height}{\includegraphics[height=0.3cm, width=0.3cm]{leetcode.png}}\ \underline{LeetCode}} ~
//     \href{https://auth.geeksforgeeks.org/user/kundusomnath610}{\raisebox{-0.2\height}{\includegraphics[height=0.3cm, width=0.3cm]{gfg.png}}\ \underline{Geeks for Geeks}} ~
// \end{center}

// %-----------EXPRIENCE---------

// \section{EXPERIENCE}
//     \vspace{-5pt}
//     \resumeSubHeadingListStart

//       \resumeProjectHeading
//           {\href{}{\textbf{\large{\underline{\textbf{Associate System Analyst At NSEIT LIMITED}}}} \href{https://drive.google.com/file/d/1xGRItmJlCDDtRSt6wNsq8LEgnVTghAvl/view?usp=sharing}{\raisebox{-0.1\height}\faExternalLink }} $|$ \large{\underline{\textbf{C Sharp}, \textbf{Dot Net}\textbf{}}}} {DEC 2022 - SEPT 2023}\\
//           \resumeItemListStart
//              \resumeItem{\normalsize{Used Technology .NET And C Sharp.For Backend,And for DataBase PostgreSQL  \textbf{C Sharp,RestAPI PostgreSQL}}}
//             \resumeItem{\normalsize{This CRUD Operation Application directly interacts with the Database Insert Data, Delete Data, Retrieve Data, and Update Data, It is used Based on User ID.}}
//             \resumeItem{\normalsize{ Develop the Backend Code efficiently to get a great Experience.}}
//             \resumeItem{\normalsize{Maintained the Code Quality And Code Readability.Writing TestCases in NUnit, and .Net Mocking .}}
//             \resumeItem{\normalsize{Developed The full Backend System to Maintain the UserDetail Performance.}}
//           \resumeItemListEnd
//           \vspace{-5pt}
          
          
//     \resumeSubHeadingListEnd
// \vspace{-12pt}

// %-----------PROGRAMMING SKILLS-----------
// \section{TECHNICAL SKILLS}
//  \begin{itemize}[leftmargin=0.15in, label={}]
//     \small{\item{
//      \textbf{\normalsize{Languages:}}{ \normalsize{Core Java, C Sharp, SQL, OOPs, DataStructure, HTML, CSS, MySQL/PostgreSQL}} \\
//      \textbf{\normalsize{Developer Tools:}}{ \normalsize{VS Code, Android Studio, Intellij Idea, PGADMIN, WorkBench, Postman, Visual Studio}} \\
//      \textbf{\normalsize{Technologies/Frameworks:}}{\normalsize{ Linux, Git and Github, Spring Boot, Collection Framework, JDBC, .Net Core}} \\
//     }}
//  \end{itemize}
//  \vspace{-12pt}


// %-----------EDUCATION-----------
// \section{EDUCATION}
//   \resumeSubHeadingListStart
//     \resumeSubheading
//       {JIS COLLEGE OF ENGINEERING}{SEPT 2019 -- JUNE 2022}
//       {B.Tech - Computer Science And Engineering - \textbf{CGPA} - \textbf{8.0}}{Kalyani, West Bengal}
//   \resumeSubHeadingListEnd
  
//   \resumeSubHeadingListStart
//     \resumeSubheading
//       {Dumkal Polytechnic}{AUG 2016 -- JULY 2019}
//       {Diploma Engineering - Computer Science And Technology  - \textbf{Percentage} - \textbf{71\%}}{Dumkal, West Bengal}
//   \resumeSubHeadingListEnd


// %-----------PROJECTS-----------
// \section{PROJECTS}
//     \vspace{-5pt}
//     \resumeSubHeadingListStart
//        \resumeProjectHeading
//           {{\textbf{\large{\underline{Market Watch Application}}} } $|$ \large{\underline{\textbf{Java}, \textbf{JavaScript}, \textbf{SpringBoot}, \textbf{PostgreSQL} \textbf{}}}}{OCT 2022 - NOV 2022 }
//           \resumeItemListStart
//             \resumeItem{\normalsize{This Application Helps to search a particular stock and see the stock's opening price and closing price.
//              \resumeItem{\normalsize{It can help the user for search a stock by NSE Symbol.}}
//               \resumeItem{\normalsize{Users can see the high prices and Low Prices with the help of Previous day data.}}
//                \resumeItem{\normalsize{Users can download the previous day's data with the help of the Stock Watch Application.}}
//             }}
            
//           \resumeItemListEnd 
//           \vspace{-12pt}
          
//       \resumeProjectHeading
//           {{\textbf{\large{\underline{Go Grocery Mobile Application}}} } $|$ \large{\underline{\textbf{Java, XML, Android Studio,FireBase}}}}{FEB 2022 - MAY 2022}
//           \resumeItemListStart
//             \resumeItem{\normalsize{This is a Graduation \textbf{Final Year} Project using an Android Application. \textbf{}}}
//             \resumeItem{\normalsize{Customers can buy the \textbf{grocery products} by helping this Application.}}
//             \resumeItem{\normalsize{It is available to \textbf{cash on the Delivery} option. \textbf{}}}
//             \resumeItem{\normalsize{Our Application helps Shopkeepers to sell their products online. \textbf{}}}
//             \resumeItem{\normalsize{Go Grocery Application both are Separate One for Users and another for shopkeepers. \textbf{}}}
//             \resumeItem{\normalsize{For This Application, we use \textbf{FireBase DataBase.} \textbf{}}}
           
//           \resumeItemListEnd
//           \vspace{-13pt}
          
          
            
          
          
//     \resumeSubHeadingListEnd
// \vspace{-5pt}








// %-----------INVOLVEMENT---------------
// \section{ACHIEVEMENTS}
//     \resumeSubHeadingListStart
//         \resumeSubheading{NSEIT LIMITED{ } }{OCT 2022 -- NOV 2022}{\underline{\textbf{DataBase Handler}}}{Chennai, TamilNadu}
//             \resumeItemListStart
//                 \resumeItem{\normalsize{\textbf{DataBase Design ER Diagram.}}}
//                 \resumeItem{\normalsize{Connection The table with the \textbf{SpringBoot Application.}}}
//                 \resumeItem{\normalsize{One to many Relation Ship in \textbf{POSTGRESQL}}}
//                 \resumeItem{\normalsize{Manipulate The DB and perform the \textbf{SQL Commend}}}
//                 \resumeItem{\normalsize{\textbf{We won the first prize in this Competition}}}
                
//             \resumeItemListEnd
//     \resumeSubHeadingListEnd
//  \vspace{-11pt}
 
//  %-----------CERTIFICATIONS---------------
// \section{CERTIFICATIONS}

// $\sbullet[.75] \hspace{0.1cm}$ {\href{https://www.credly.com/badges/df31ef0f-8e8b-4d05-b500-08dede0106c4/print} {{\textbf{AWS Academy Cloud Foundations Issue By:- Amazon Web Services Training and Certification}}} \hspace{1.6cm}
//  \\


// \end{document}
