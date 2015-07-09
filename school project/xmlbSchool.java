package xmlbSchoolSerialization;

import com.school.schemas.*;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlValidationError;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by jan on 21/4/14.
 */
public class xmlbSchool {
    public static void main(String[] args) throws Exception {
        List<XmlValidationError> errors = new ArrayList<>();
        XmlOptions options = new XmlOptions();
        //enable on the fly validation
        options.setValidateOnSet();
        options.setErrorListener(errors);


        SchoolDocument sd = SchoolDocument.Factory.newInstance(options);
        SchoolDocument.School sc = sd.addNewSchool();
        sc.setSchoolName("Hydrogen");

        //Address

        Address addr = sc.addNewAddress();
        addr.setArea("abc");
        addr.setState("AP");
        addr.setCity("Hyderabad");
        addr.setZipcode("5210");

        //BoardMembers
        BoardMembers bms = sc.addNewBoardMembers();
        BoardMember bm = bms.addNewBoardMember();
        bm.setName("amar");
        bm.setId(9);
        bm.setFrom(Calendar.getInstance());

        //Members

        Members mems = sc.addNewMembers();
        Student s1 = mems.addNewMember();
        s1.setName("jan");
        s1.setId(5);
        s1.setClass1(3);
/*
        //Build an array list to store the validation erros
        List<XmlValidationError> errors =new ArrayList();
        XmlOptions options = new XmlOptions();
        options.setErrorListener(errors);

        //validate weather the sd (School docuument) is valid in accrdance with the xsd
        boolean isValid = sd.validate(options);
        System.out.print(isValid ? "Document is valid" : " Document is not valid");
        for (XmlValidationError error:errors)
        {
            System.out.println("Message"+error.getMessage());
            System.out.println("Offending Q Name is"+error.getOffendingQName());
        }

        if(isValid) {
            sd.save(new File("/tmp/out.xml"));
        }*/
        sd.save(new File("/tmp/out.xml"));

        //parse the generated xml fike
        SchoolDocument psd = SchoolDocument.Factory.parse(new File("/tmp/out.xml"));
        SchoolDocument.School psc = psd.getSchool();
        System.out.println("School Name :" + psc.getSchoolName());
        Address add = psc.getAddress();
        System.out.println("City :" + add.getCity());
        System.out.println("state :" + add.getState());
        System.out.println("zip :" + add.getZipcode());
        psd.save(new File("/tmp/out.xml"));
    }
}
