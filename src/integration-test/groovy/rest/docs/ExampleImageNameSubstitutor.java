package rest.docs;

import org.testcontainers.utility.DockerImageName;
import org.testcontainers.utility.ImageNameSubstitutor;

public class ExampleImageNameSubstitutor extends ImageNameSubstitutor {

    @Override
    public DockerImageName apply(DockerImageName original) {
        // convert the original name to something appropriate for
        // our build environment
        return DockerImageName.parse(System.getenv("TESTCONTAINERS_IMAGE"))
                    .asCompatibleSubstituteFor("mysql");
    }

    @Override
    protected String getDescription() {
        // used in logs
        return "example image name substitutor";
    }
}