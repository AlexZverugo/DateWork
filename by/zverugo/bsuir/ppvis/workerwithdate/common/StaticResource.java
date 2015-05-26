package by.zverugo.bsuir.ppvis.workerwithdate.common;

/**
 * Created by Alex on 23.05.2015.
 */
public enum StaticResource {
    OPEN_IMAGE("D:/dev/DateWorkMVC/src/by/zverugo/bsuir/ppvis/workerwithdate/resources/open.png"),
    SAVE_IMAGE("D:/dev/DateWorkMVC/src/by/zverugo/bsuir/ppvis/workerwithdate/resources/save.png"),
    ADD_IMAGE("D:/dev/DateWorkMVC/src/by/zverugo/bsuir/ppvis/workerwithdate/resources/add.png"),
    SEARCH_IMAGE("D:/dev/DateWorkMVC/src/by/zverugo/bsuir/ppvis/workerwithdate/resources/search.png"),
    FIRST_IMAGE("D:/dev/DateWorkMVC/src/by/zverugo/bsuir/ppvis/workerwithdate/resources/first.png"),
    LAST_IMAGE("D:/dev/DateWorkMVC/src/by/zverugo/bsuir/ppvis/workerwithdate/resources/last.png"),
    PREV_IMAGE("D:/dev/DateWorkMVC/src/by/zverugo/bsuir/ppvis/workerwithdate/resources/prev.png"),
    NEXT_IMAGE("D:/dev/DateWorkMVC/src/by/zverugo/bsuir/ppvis/workerwithdate/resources/next.png"),
    REMOVE_IMAGE("D:/dev/DateWorkMVC/src/by/zverugo/bsuir/ppvis/workerwithdate/resources/remove.png");

    private String path;

    StaticResource(String path) {
        this.path = path;
    }

    public String path() {

        return path;
    }
}
