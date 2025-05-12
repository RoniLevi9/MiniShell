תרגיל בתכנות- minishell
חלק 1 : מחקר על מערכת הקבצים

שאלה 1. איך יוצרים תיקייה?

יש לייבא את המחלקה הנחוצה (File)
יוצרים אובייקט של המחלקה File (עם שם הנתיב הרצוי אם רוצים לפתוח במקום ספציפי, או בלי לשמירה בנתיב יחסי – בו התכנית רצה)
משתמשים בפקודת mkdir() ליצירת התיקיה
חשוב לבדוק אם התיקיה קיימת למניעת כפילויות בעזרת exists()

דוגמת קוד ליצירת תיקיה-

File newFolder = new File("Folder");
if(!newFolder.exists()){
    newFolder.mkdir();
    System.out.println("The Folder was created successfully");
}
else{ 
    System.out.println("The Folder already exists");
}



שאלה 2. איך יוצרים קובץ?

יוצרים אובייקט עם שם הקובץ הרצוי - של מחלקת File
משתמשים ליצירת הקובץ בפקודת createNewFile()
נשתמש במנגנון try , catch ליצירת הקובץ לטיפול בבעיות .

דוגמת קוד ליצירת קובץ-
File newF = new File("file.txt");
try{
    if(newF.createNewFile()){
        System.out.println("succsess");
    }
    else{
        System.out.println("already exists");
    }
} catch (IOException r) {
    System.out.println("error");
    r.printStackTrace(); - נוסיף פונקציה להדפסת פרטי השגיאה במידה וקיימת
}



שאלה 3. איך בודקים אם קובץ/תיקיה קיימים?

משתמשים במתודת exists() עם שם האובייקט שבו כתבנו את שם התיקיה/ קובץ הרצויים

דוגמת קוד לבדיקה-
if(newF.exists()){
    System.out.println("Exists");
}
else{
 System.out.println("Doesn't Exists");   
}


שאלה 4. איך מציגים תוכן תיקייה?

יוצרים אובייקט מסוג File שמצביע על התיקיה
משתמשים במתודת listFiles() כדי לקבל את כל התוכן שבתוכה
עוברים עם לולאה ומדפיסים שם של כל פריט בעזרת getName()

דוגמת קוד להצגת תוכן-
File NewF = new File("MyFolder");
File[] files = NewF.listFiles();
for (File file : files) {
    System.out.println(file.getName());
}



מה ההבדל בין  File ל Path?

File – מחלקה לייצוג של תיקיה/קובץ, דרכה ניתן ליצור קבצים, תיקיות, למחוק, להציג את התוכן ועוד.

Path – מחלקה לייצוג נתיב של תיקיה/קובץ

עם File אפשר לבצע את הפעולות הבסיסיות וגם לראות את הנתיב של התיקיה/קובץ הרצוי

עם path משתמשים כדי לראות את הנתיב של התיקיה/קובץ הרצוי- בשביל פעולה מדוייקת יותר להצבעה על נתיב רצוי לעבוד עם path.