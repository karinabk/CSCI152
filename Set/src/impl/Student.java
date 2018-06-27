package impl;

public class Student {
    private String name;
    private int id;
    public Student(String name, int id){
        this.name = name;
        this.id = id;
    }

    public String getName(){
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student){
            Student sobj =(Student) obj;
            return id==sobj.id && name.equals(sobj.name);
        }
        return false;
    }



    public int getId(){
        return id;
    }

    public String toString(){
        return "["+getName() + ";" + getId() + "]";
    }

}
