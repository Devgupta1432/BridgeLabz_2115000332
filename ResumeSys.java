import java.util.ArrayList;
import java.util.List;
abstract class JobRole {
    abstract void roleDescription();
}

class SoftwareEngineer extends JobRole {
    void roleDescription() {
        System.out.println("Role: Software Engineer - Develop and maintain software applications.");
    }
}

class DataScientist extends JobRole {
    void roleDescription() {
        System.out.println("Role: Data Scientist - Analyze and interpret complex data.");
    }
}

class ProductManager extends JobRole {
    void roleDescription() {
        System.out.println("Role: Product Manager - Oversee product development and strategy.");
    }
}

class Resume<T extends JobRole> {
    T jobRole;
    
    Resume(T jobRole) {
        this.jobRole = jobRole;
    }

    void processResume() {
        jobRole.roleDescription();
    }

    void validateResumes(List<? extends JobRole> roles) {
        for (JobRole role : roles) {
            role.roleDescription();
        }
    }
}

public class ResumeSys {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> softwareEngineerResume = new Resume<>(new SoftwareEngineer());
        Resume<DataScientist> dataScientistResume = new Resume<>(new DataScientist());
        Resume<ProductManager> productManagerResume = new Resume<>(new ProductManager());
        
        softwareEngineerResume.processResume();
        dataScientistResume.processResume();
        productManagerResume.processResume();
        
        List<JobRole> allRoles = new ArrayList<>();
        allRoles.add(new SoftwareEngineer());
        allRoles.add(new DataScientist());
        allRoles.add(new ProductManager());
        
        Resume<JobRole> resumeScreening = new Resume<>(new SoftwareEngineer());
        resumeScreening.validateResumes(allRoles);
    }
}
