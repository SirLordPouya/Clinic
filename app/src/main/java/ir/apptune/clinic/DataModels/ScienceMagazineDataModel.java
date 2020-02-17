package ir.apptune.clinic.DataModels;

import java.util.List;

/**
 * Created by Pouya on 29/11/2016.
 */

public class ScienceMagazineDataModel {

    /**
     * Type : 1
     * List : [{"Id":1,"Title":"موضوع تستی","Photo":"http://drapplication.artiwhite.ir/Content/Images/Care/1.jpg","Date":"9 آذر 1395"}]
     * Message : اطلاعات اعلانات با موفقیت نمایش داده شد
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

    @Override
    public String toString() {
        return "ScienceMagazineDataModel{" +
                "Type=" + Type +
                ", Message='" + Message + '\'' +
                ", List=" + List +
                '}';
    }

    public static class ListBean {
        /**
         * Id : 1
         * Title : موضوع تستی
         * Photo : http://drapplication.artiwhite.ir/Content/Images/Care/1.jpg
         * Date : 9 آذر 1395
         */

        private int Id;
        private String Title;
        private String Photo;
        private String Date;

        @Override
        public String toString() {
            return "ListBean{" +
                    "Id=" + Id +
                    ", Title='" + Title + '\'' +
                    ", Photo='" + Photo + '\'' +
                    ", Date='" + Date + '\'' +
                    '}';
        }

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

        public String getDate() {
            return Date;
        }

        public void setDate(String Date) {
            this.Date = Date;
        }
    }
}
