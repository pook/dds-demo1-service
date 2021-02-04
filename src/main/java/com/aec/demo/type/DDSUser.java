

/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

package com.aec.demo.type;

import java.io.Serializable;

import com.aec.demo.domain.User;
import com.aec.demo.domain.kafka.sqlserver.Field;
import com.rti.dds.cdr.CdrHelper;
import com.rti.dds.infrastructure.Copyable;

public class DDSUser implements Copyable, Serializable{

    
	private static final long serialVersionUID = -1590141828223113343L;
	public int userId = (int)0;
    public String userFname= (String)""; /* maximum length = (255) */
    public String userLName= (String)""; /* maximum length = (255) */
    public int age = (int)0;
    public String address= (String)""; /* maximum length = (255) */

    
    public static final DDSUser createInstance(User a, Field[]fields) {
		return new DDSUser(a, fields);
	}
    public static final DDSUser createInstance(User a) {
		return new DDSUser(a);
	}
    
	public DDSUser(User a, Field[]fields) {
		copyFromKafka(a, fields);
	}
	public DDSUser(User a) {
		copyFromKafka(a);
	}
    public DDSUser() {

    }
    public DDSUser (DDSUser other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        DDSUser self;
        self = new  DDSUser();
        self.clear();
        return self;

    }

    public void clear() {

        userId = (int)0;
        userFname = (String)"";
        userLName = (String)"";
        age = (int)0;
        address = (String)"";
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        DDSUser otherObj = (DDSUser)o;

        if(userId != otherObj.userId) {
            return false;
        }
        if(!userFname.equals(otherObj.userFname)) {
            return false;
        }
        if(!userLName.equals(otherObj.userLName)) {
            return false;
        }
        if(age != otherObj.age) {
            return false;
        }
        if(!address.equals(otherObj.address)) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += (int)userId;
        __result += userFname.hashCode(); 
        __result += userLName.hashCode(); 
        __result += (int)age;
        __result += address.hashCode(); 
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>DDSUserTypeSupport</code>
    * rather than here by using the <code>-noCopyable</code> option
    * to rtiddsgen.
    * 
    * @param src The Object which contains the data to be copied.
    * @return Returns <code>this</code>.
    * @exception NullPointerException If <code>src</code> is null.
    * @exception ClassCastException If <code>src</code> is not the 
    * same type as <code>this</code>.
    * @see com.rti.dds.infrastructure.Copyable#copy_from(java.lang.Object)
    */
    public Object copy_from(Object src) {

        DDSUser other = (DDSUser) src;
        this.userId = other.userId;
        this.userFname = other.userFname;
        this.userLName = other.userLName;
        this.age = other.age;
        this.address = other.address;

        return this;
    }
    
    public void copyFromKafka(User other, Field[] fields) {
    	   
           this.userId = other.userId;
           this.userFname = other.userFname;
           this.userLName = other.userLName;
           this.age = other.age;
           this.address = other.address;
    }
    public void copyFromKafka(User other) {
 	   
        this.userId = other.userId;
        this.userFname = other.userFname;
        this.userLName = other.userLName;
        this.age = other.age;
        this.address = other.address;
 }

    public String toString(){
        return toString("", 0);
    }

    public String toString(String desc, int indent) {
        StringBuffer strBuffer = new StringBuffer();        

        if (desc != null) {
            CdrHelper.printIndent(strBuffer, indent);
            strBuffer.append(desc).append(":\n");
        }

        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("userId: ").append(userId).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("userFname: ").append(userFname).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("userLName: ").append(userLName).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("age: ").append(age).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("address: ").append(address).append("\n");  

        return strBuffer.toString();
    }

}
