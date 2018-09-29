package com.niezhiliang.diy.annotation.utils;

import com.niezhiliang.diy.annotation.domain.ColumnBean;
import com.niezhiliang.diy.annotation.annos.Column;
import com.niezhiliang.diy.annotation.annos.Table;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 */
public class AnnoUtils {

    public static String getTableName(Class<?> bean) {
        String name = null;

        if (bean.isAnnotationPresent(Table.class)) {
            Annotation tableAnnotation = bean.getAnnotation(Table.class);

            try {
                Method method = Table.class.getMethod("name");
                name = (String) method.invoke(tableAnnotation);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return name;
    }

    public static List<ColumnBean>  getColumns(Class<?> bean) {

        List<ColumnBean> columns = new ArrayList<ColumnBean>();

        Field [] fields = bean.getDeclaredFields();

        for (int i = 0; i<fields.length; i++) {
            Field field = fields[i];
            if (field.isAnnotationPresent(Column.class)) {
                String name = null;
                int length = 0;
                String defaultValue = null;
                String type = null;

                Annotation columnAnnotation = field.getAnnotation(Column.class);

                try {
                    Method nameMethod = Column.class.getMethod("name");
                    Method lengthMethod = Column.class.getMethod("length");
                    Method defauLtMethod = Column.class.getMethod("defaultValue");

                    name = (String) nameMethod.invoke(columnAnnotation);
                    length = (Integer)lengthMethod.invoke(columnAnnotation);
                    defaultValue = (String) defauLtMethod.invoke(columnAnnotation);

                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (int.class.isAssignableFrom(field.getType())
                        || Integer.class.isAssignableFrom(field.getType())) {

                    type = "int";
                } else if (String.class.isAssignableFrom(field.getType())) {
                    type = "varchar";
                } else if (Date.class.isAssignableFrom(field.getType())) {
                    type = "datetime";
                }
                columns.add(new ColumnBean(type,name,length,defaultValue));
            }
        }

        return columns;
    }

    public static String createTable(Class<?> bean) {
        String tableName = getTableName(bean);
        List<ColumnBean> columnBeans = getColumns(bean);

            StringBuffer createTableSql = new StringBuffer("create table ");
        if (tableName != null && !tableName.equals("") && !columnBeans.isEmpty()) {
                createTableSql.append(tableName);
                createTableSql.append("(");

            for (int i = 0; i < columnBeans.size(); i++) {
                ColumnBean columnBean = columnBeans.get(i);

                createTableSql.append(columnBean.getName());
                createTableSql.append(" ");

                createTableSql.append(columnBean.getType());

                if (columnBean.getLength() != 0) {
                    createTableSql.append("(");
                    createTableSql.append(columnBean.getLength());
                    createTableSql.append(")");
                }

                if (columnBean.getDefaultValue() != null && columnBean.getDefaultValue().length() != 0) {
                    createTableSql.append(" default ");
                    createTableSql.append(columnBean.getDefaultValue());
                }

                if (i != columnBeans.size() - 1) {
                    createTableSql.append(",");
                }
            }

            createTableSql.append(")");
        }

        return createTableSql.toString();
    }

}
