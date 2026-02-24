import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

public class XMLUsuarios {

    private static final String FICHERO = "usuarios.xml";

    public static void guardarUsuario(usuario u) {

        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc;

            File file = new File(FICHERO);

            if (file.exists()) {
                doc = builder.parse(file);
                doc.getDocumentElement().normalize();
            } else {
                doc = builder.newDocument();
                Element root = doc.createElement("usuarios");
                doc.appendChild(root);
            }

            Element root = doc.getDocumentElement();

            Element usuarioXML = doc.createElement("usuario");

            Element id = doc.createElement("id");
            id.setTextContent(String.valueOf(u.getIdUsuario()));
            usuarioXML.appendChild(id);

            Element tipo = doc.createElement("tipo");
            tipo.setTextContent(u.getClass().getSimpleName());
            usuarioXML.appendChild(tipo);

            Element nombre = doc.createElement("nombre");
            nombre.setTextContent(u.getNombre());
            usuarioXML.appendChild(nombre);

            Element apellidos = doc.createElement("apellidos");
            apellidos.setTextContent(u.getApellidos());
            usuarioXML.appendChild(apellidos);

            Element dni = doc.createElement("dni");
            dni.setTextContent(u.getDni());
            usuarioXML.appendChild(dni);

            Element activo = doc.createElement("activo");
            activo.setTextContent(String.valueOf(u.isActivo()));
            usuarioXML.appendChild(activo);

            root.appendChild(usuarioXML);

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(new DOMSource(doc), new StreamResult(file));

            System.out.println("Usuario guardado en XML correctamente.");

        } catch (Exception e) {
            System.out.println("ERROR XML:");
            e.printStackTrace();
        }
    }
}