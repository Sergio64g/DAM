package Utils;

import javax.swing.table.AbstractTableModel;

public class ModeloTabla extends AbstractTableModel {

    Personas personas;
    private String[] columnas = new String[]{"ID", "NOMBRE", "APELLIDO", "EDAD"};;
    Boolean[] editables = new Boolean[]{false, false, false, true};
    private Class[] tipos = {String.class, String.class, String.class, Integer.class};

    public ModeloTabla(Personas personas) {
        this.personas = personas;
    }

    @Override
    public int getRowCount() {
        return personas.list().size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return personas.list().get(rowIndex).getId();
            case 1:
                return personas.list().get(rowIndex).getNombre();
            case 2:
                return personas.list().get(rowIndex).getApellidos();
            case 3:
                return personas.list().get(rowIndex).getEdad();
            default:
                return null;
        }
    }


    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return tipos[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return editables[columnIndex];
    }

    public void anadirDatos(Persona p){
        personas.list().add(p);
        fireTableDataChanged();
    }

    public void borrarDatos(int row){
        personas.list().remove(row);
        fireTableDataChanged();
    }

    public Persona personaSeleccionada(int index) {
        return personas.list().get(index);
    }
}
