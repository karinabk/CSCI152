package impl;

public class Student implements Comparable<Student> {
    private Integer id;
    private String name;

    public Student(String name, int id){
        this.id = id;
        this.name = name;
    }
    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }



    @Override
    public int compareTo(Student o) {
        return this.id.compareTo(o.getId());
    }

    @Override
    public String toString(){
        return "| name: " + this.name + "ID:" + this.id + "| ";
    }

    public int hashCode(){
        //return 42;
        return getId();
    }

    public boolean equals(Object obj){
        if(obj instanceof Student){
            Student sobj = (Student) obj;
            return id == sobj.id && name == sobj.name;
        }
        return false;
    }
}
