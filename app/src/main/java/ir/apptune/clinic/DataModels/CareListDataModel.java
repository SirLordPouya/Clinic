package ir.apptune.clinic.DataModels;

import java.util.List;

/**
 * Created by Pouya on 01/12/2016.
 */

public class CareListDataModel {


    /**
     * Type : 1
     * List : [{"Id":1,"Title":"تست جدید","Photo":"http://drapplication.artiwhite.ir/Content/Images/Care/1.jpg"}]
     * Message : اطلاعات مجموعه با موفقیت نمایش داده شد.
     */

    private int Type;
    private String Message;
    private java.util.List<ListBean> List;

    public int getType() {
        return Type;
    }

    public void setType(int Type) {
        this.Type = Type;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public List<ListBean> getList() {
        return List;
    }

    public void setList(List<ListBean> List) {
        this.List = List;
    }

    public static class ListBean {
        /**
         * Id : 1
         * Title : تست جدید
         * Photo : http://drapplication.artiwhite.ir/Content/Images/Care/1.jpg
         */

        private int Id;
        private String Title;
        private String Photo;

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String Title) {
            this.Title = Title;
        }

        public String getPhoto() {
            return Photo;
        }

        public void setPhoto(String Photo) {
            this.Photo = Photo;
        }
    }
}
