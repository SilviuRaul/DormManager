package ro.siit.dormmanager.controller;

import ro.siit.dormmanager.model.Dorm;
import ro.siit.dormmanager.service.DormService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Raul on 11.10.2017.
 */
@WebServlet(urlPatterns = {"/dorms"})
public class DormController extends HttpServlet {

    private static final String ACTION = "action";
    private static final String LIST = "list";
    private static final String DELETE = "delete";
    private static final String SHOW_FORM = "showForm";
    private static final String ADD = "add";
    private static final String EDIT = "edit";

    public static final String DORM_LIST = "dormList";

    private DormService dormService;

    @Override
    public void init() throws ServletException {
        this.dormService = DormService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter(ACTION);

        if (action == null) {
            action = LIST;
        }

        switch (action) {
            case LIST:
                list(req, resp);
                break;
            case SHOW_FORM:
                String dormId = req.getParameter("id");

                if (dormId != null) {
                    Dorm dorm = dormService.getDorm( Integer.parseInt(dormId) );

                    if (dorm != null) {
                        req.setAttribute("action", "edit");
                        req.setAttribute("dormId", dorm.getDormId());
                        req.setAttribute("name", dorm.getName());
                        req.setAttribute("roomSize", dorm.getRoomSize());
                        req.setAttribute("dormType", dorm.getDormType());
                        req.setAttribute("numberOfRooms", dorm.getNumberOfRooms());
                        req.setAttribute("buttonLabel", "Update");
                    }
                } else {
                    req.setAttribute("action", "add");
                    req.setAttribute("buttonLabel", "Add");
                }
                req.getRequestDispatcher("/WebContent/dorms/form.jsp").forward(req,resp);
                break;
            case DELETE:
                String dormIdToDelete = req.getParameter("id");

                if (dormIdToDelete != null) {
                    dormService.deleteDorm( Integer.parseInt( dormIdToDelete ));
                }

                list(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter(ACTION);

        if (action == null) {
            action = LIST;
        }

        switch (action) {
            case LIST:
                list(req, resp);
                break;
            case ADD:
                Dorm newDorm = new Dorm();
                newDorm.setName( req.getParameter("name") );
                newDorm.setRoomSize( Integer.parseInt( req.getParameter("roomSize") ) );
                newDorm.setDormType( req.getParameter("dormType") );
                newDorm.setNumberOfRooms( Integer.parseInt( req.getParameter("numberOfRooms") ) );

                dormService.addDorm(newDorm);

                list(req, resp);
                break;
            case EDIT:
                Dorm updatedDorm = new Dorm();
                updatedDorm.setDormId( Integer.parseInt( req.getParameter("dormId") ) );
                updatedDorm.setName( req.getParameter("name") );
                updatedDorm.setRoomSize( Integer.parseInt( req.getParameter("roomSize") ) );
                updatedDorm.setDormType( req.getParameter("dormType") );
                updatedDorm.setNumberOfRooms( Integer.parseInt( req.getParameter("numberOfRooms") ) );

                dormService.updateDorm(updatedDorm);

                list(req, resp);
                break;
        }
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Dorm> dormList = dormService.getDorms();
        req.setAttribute(DORM_LIST, dormList);
        req.getRequestDispatcher("/WebContent/dorms/list.jsp").forward(req, resp);
    }

}
