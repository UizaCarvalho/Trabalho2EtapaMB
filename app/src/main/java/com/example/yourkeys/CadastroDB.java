package com.example.yourkeys;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.security.AccessControlContext;
import java.util.ArrayList;
import java.util.List;

public class CadastroDB extends SQLiteOpenHelper {
    //nome do banco
    public static final String NOME_BANCO = "minhassenhas";
    private static final int VERSAO_BANCO = 1;
    private static final String TAG = "sql";

    public CadastroDB(AccessControlContext context){
        //context, nome do banco, factory, versao
        super(context,NOME_BANCO,null,VERSAO_BANCO);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        Log.d(TAG, "Criando a tabela Cadastro...");
        db.execSQL("create table if not exists Cadastro(_id integer primary key autoincrement," +
                "usuario text,senha text,aplicativo text,email text);");
        Log.d(TAG, "Tabela Cadastro criada com sucesso");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        //Caso mude a versao do banco de dados, podemos executar um SQL aqui
    }
    //Insere um novo cadastro, ou atualiza se ja existe
    public long save(Cadastro cadastro){
        long id = cadastro.getId();
        SQLiteDatabase db = getWritableDatabase();

        try{
            ContentValues values = new ContentValues();
            values.put("usuario",cadastro.getUsuario());
            values.put("senha",cadastro.getSenha());
            values.put("aplicativo",cadastro.getAplicativo());
            values.put("email",cadastro.getEmail());

            if(id!=0){
                String _id = String.valueOf(cadastro.getId());
                String[] whereArgs = new String[]{_id};
                //update cadastro set values= ... where _id=?
                int count = db.update("cadastro",values,"_id=?",whereArgs);
                return count;
            }
            else{
                //insert into cadastro values (...)
                id = db.insert("cadastro","",values);
                return id;
            }
        }finally {
            db.close();
        }
    }
    //delete o cadastro
    public int delete(Cadastro cadastro){
        SQLiteDatabase db = getWritableDatabase();
        try{
            //delete from cadastro where _id=?
            int count = db.delete("cadastro", "_id=?", new String[]{String.valueOf(cadastro.id)});
            Log.i(TAG, "Deletou [" + count + "] registro");
            return count;
        }
        finally {
            db.close();
        }
    }
    //deleta o cadastro pelo aplicativo
    public int deleteCadastroByNome(String user){
        SQLiteDatabase db = getWritableDatabase();
        try{
            //delete from cadastro where _id=?
            int count = db.delete("cadastro", "usuario=?", new String[]{user});
            Log.i(TAG, "Deletou [" + count + "] registro");
            return count;
        }
        finally {
            db.close();
        }
    }
    //Consulta a lista com todos os usuarios
    public List<Cadastro> findAll(){
        SQLiteDatabase db = getWritableDatabase();
        try{
            //select *from usuario
            Cursor c = db.query("cadastro", null, null, null, null, null, null, null);
            return toList(c);
        }
        finally {
            db.close();
        }
    }
    //Consulta o usuario pelo nome
    public List<Cadastro> findAllByTipo(String user){
        SQLiteDatabase db = getWritableDatabase();
        try{
            //select *from usuario where nome=?
            Cursor c = db.query("cadastro", null, "usuario='" + user + "'", null, null, null, null, null);
            return toList(c);
        }
        finally {
            db.close();
        }
    }
    //Lê o cursor e cria a lista de usuarios
    private List<Cadastro> toList(Cursor c){
        List<Cadastro> user = new ArrayList<Cadastro>();

        if(c.moveToFirst()){
            do{
                Cadastro u = new Cadastro();
                user.add(u);
                //recupera os atributos de usuario
                u.id = c.getInt(c.getColumnIndex("_id"));
                u.usuario = c.getString(c.getColumnIndex("usuario"));
                u.senha = c.getString(c.getColumnIndex("senha"));
                u.aplicativo = c.getString(c.getColumnIndex("aplicativo"));
                u.email = c.getString(c.getColumnIndex("email"));


            }while(c.moveToNext());
        }
        return user;
    }
    //Executa um SQL
    public void execSQL(String sql){
        SQLiteDatabase db = getWritableDatabase();
        try{
            db.execSQL(sql);
        }
        finally {
            db.close();
        }
    }
    //Executa um SQL
    public void execSQL(String sql, Object[] args){
        SQLiteDatabase db = getWritableDatabase();
        try{
            db.execSQL(sql,args);
        }
        finally {
            db.close();
        }
    }
}
/*public class BDCrud {

    private SQLiteDatabase db;

    public BDCrud(Context context){
        BDCrud auxdb = new BDCrud(context);
        db =  auxdb.getWritableDatabase();
    }

    public void cadastrar(Usuario usuario){
        ContentValues dados = new ContentValues();
        dados.put("usuario",usuario.getUsuario());
        dados.put("senha",usuario.getSenha());
        dados.put("nome",usuario.getNome());
        dados.put("email",usuario.getEmail());
        dados.put("telefone",usuario.getTelefone());
        dados.put("idade",usuario.getIdade());

        db.insert("Usuario",null, dados);

    }
    public void editar(Usuario usuario){
        ContentValues dados = new ContentValues();
        dados.put("usuario",usuario.getUsuario());
        dados.put("senha",usuario.getSenha());
        dados.put("nome",usuario.getNome());
        dados.put("email",usuario.getEmail());
        dados.put("telefone",usuario.getTelefone());
        dados.put("idade",usuario.getIdade());

        db.update("Usuario", dados,"_id = ?",new String[]{""+usuario.getId()});

    }
    public void deletar(Usuario usuario){
            db.delete("Usuario", "_id = "+usuario.getId(),null);

    }
    public List<Usuario> listar(){
        List<Usuario> list = new ArrayList<Usuario>();
        String[] colunas = new String[]{"_id","nome","email","telefone","idade"};

        Cursor busca = db.query("Usuario", colunas, null, null, null, null, "nome ASC");//ordenar por nome

        if(busca.getCount() > 0){
            busca.moveToFirst();
            do{
                Usuario us = new Usuario();
                us.setId((int) busca.getInterger(0));
                us.setNome(busca.geString(3));
                us.setEmail(busca.getstring(4));
                us.setTelefone(busca.getString(5));
                us.setIdade(busca.getInterger(6));
                list.add(us);

            }while (busca.moveToNext());
        }
        return(list);
    }
}
*/