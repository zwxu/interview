package cou.ustc.zwxu.thread.person;

/*
 * 不会改变的Person
 */
public final class ImmutablePerson {
    private final String name;
    private final String address;
    public ImmutablePerson(String name, String address) {
        this.name = name;
        this.address = address;
    }
    //保护一个可变对象同时，需考虑他关联的对象是否仍具有安全性
    public ImmutablePerson(MutablePerson person) {
    	synchronized(person){
	        this.name = person.getName();
	        this.address = person.getAddress();
    	}
    }
    public MutablePerson getMutablePerson() {
        return new MutablePerson(this);
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String toString() {
        return "[ ImmutablePerson: " + name + ", " + address + " ]";
    }
}
