package protobuf;



/**
 * Created by sunzhuhuan Administrator on 2017/8/31.
 */
public class Protobuf {
    public static void main(String[] args) {
        PersonMessage.Person.Builder personOrBuilder = PersonMessage.Person.newBuilder().setId(1).setName("test");

    }
}
