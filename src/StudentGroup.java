import java.util.Date;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 *
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
    private int c;
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
        c=length;
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		return students;
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
		if(students==null)
            throw new IllegalArgumentException();
        else
        {
            this.students=students;
            c=students.length;
            System.out.println(c);
        }
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
		if(index<0 || index>=c)
            throw new IllegalArgumentException();
		return students[index];
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
        if(student==null || index>=c ||     index<0)
            throw new IllegalArgumentException();
        else
            students[index]=student;
	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
        int i,j,k;
        if(student==null)
            throw new IllegalArgumentException();

        Student temp[]=new Student[c+1];
        temp[0]=student;k=1;
        for(i=0;i<c;i++)
            temp[k++]=students[i];
        students=temp;
        c++;
	}

	@Override
	public void addLast(Student student) {
         int i,j,k;
        if(student==null)
            throw new IllegalArgumentException();

        Student temp[]=new Student[c+1];
        for(i=0;i<c;i++)
            temp[i]=students[i];
        temp[i]=student;
        students=temp;
        c++;
	}

	@Override
	public void add(Student student, int index) {
        int i,j,k=0;
        if(student==null || index<0 || index>=c)
            throw new IllegalArgumentException();

        Student temp[]=new Student[c+1];
        for(i=0;i<index;i++)
            temp[k++]=students[i];
        temp[k++]=student;
        for(;i<c;i++)
            temp[k++]=students[i];

        students=temp;
        c++;
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
		int i,j,k=0;
        if( index<0 || index>=c)
            throw new IllegalArgumentException();

        Student temp[]=new Student[c-1];
        for(i=0;i<index;i++)
            temp[k++]=students[i];
        i++;
        for(;i<c;i++)
            temp[k++]=students[i];

        students=temp;
        c--;
	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
        int i,j,k=0;
        Student temp[]=new Student[c-1];
        if(student==null)
            throw new IllegalArgumentException();

        for(i=0;i<c;i++)
            if(!student.equals(students[i]))
                temp[k++]=students[i];
        if(k==i)
                throw new IllegalArgumentException("Student not exist");
        c--;
        students=temp;




	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
        int i;
        if( index<0 || index>=c)
            throw new IllegalArgumentException();
         Student temp[]=new Student[index+1];
         for(i=0;i<=index;i++)
            temp[i]=students[i];
         students=temp;
         c=index+1;



	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
		int i,j,k=0;
        if(student==null)
            throw new IllegalArgumentException();

        for(i=0;i<c;i++)
            if(student==students[i])
                break;
         Student temp[]=new Student[i+1];
        for(k=0;k<=i;k++)
            temp[k]=students[k];
         students=temp;
         c=i+1;



	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
		int i,k=0;
        if( index<0 || index>=c)
            throw new IllegalArgumentException();
         Student temp[]=new Student[c-index];
         for(i=index;i<c;i++)
            temp[k++]=students[i];
         students=temp;
         c=k;
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
        int i,j=0,k=0;
        if(student==null)
            throw new IllegalArgumentException();

        for(i=0;i<c;i++)
            if((student==students[i]))
                break;
         Student temp[]=new Student[c-i];
        for(k=i;k<c;k++)
            temp[j++]=students[k];
         students=temp;
         c=j;


	}

	@Override
	public void bubbleSort() {
        Student temp;
        for(int i=0;i<c-1;i++)
            for(int j=i+1;j<c;j++)
                if(students[i].compareTo(students[j])>0)
                {
                    temp=students[i];
                    students[i]=students[j];
                    students[j]=temp;
                }

	}

	@Override
	public Student[] getByBirthDate(Date date) {
	    if(date==null)
            throw new IllegalArgumentException();

        int dc=0;
		for(int i=0;i<c;i++)
        {
            Date d1=students[i].getBirthDate();
            if(date.before(d1) || date.equals(d1))
                dc++;
        }
        Student temp[]=new Student[dc];
        int        k=0;
        for(int i=0;i<c;i++)
        {
            Date d1=students[i].getBirthDate();
            if(date.before(d1) || date.equals(d1))
                temp[k++]=students[i];
        }
        return temp;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
        if(lastDate==null || firstDate==null)
            throw new IllegalArgumentException();

		int dc=0;
		for(int i=0;i<c;i++)
        {
            Date d1=students[i].getBirthDate();
            if((lastDate.before(d1)&&firstDate.after(d1))|| lastDate.equals(d1) || firstDate.equals(d1))
                dc++;
        }
        Student temp[]=new Student[dc];
        int        k=0;
        for(int i=0;i<c;i++)
        {
            Date d1=students[i].getBirthDate();
            if((lastDate.before(d1)&&firstDate.after(d1))|| lastDate.equals(d1) || firstDate.equals(d1))
                temp[k++]=students[i];
        }
        return temp;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
        Student s[]=students;
        double max=s[0].getAvgMark();
        for(int i=1;i<c;i++)
        {
            if(max<s[i].getAvgMark())
                max=s[0].getAvgMark();
        }
        int mc=0;
        for(int i=0;i<c;i++)
        {
            if(max==s[i].getAvgMark())
                mc++;
        }

        Student temp[]=new Student[mc];
        int k=0;
        for(int i=0;i<c;i++)
        {
            if(max==s[i].getAvgMark())
                temp[k++]=students[i];
        }

		return temp;
	}

	@Override
	public Student getNextStudent(Student student) {
		int i;
		if(student==null)
            throw new IllegalArgumentException();
        for(i=0;i<c;i++)
            if((student==students[i]))
                break;
        if(i<c-1)
		return students[i+1];
		else
             throw new IllegalArgumentException();

	}
	public void print()
	{
	    for(int i=0;i<c;i++)
            System.out.println(students[i].getFullName());

	}
}
