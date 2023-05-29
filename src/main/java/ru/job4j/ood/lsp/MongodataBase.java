package ru.job4j.ood.lsp;

public class MongodataBase extends DataBase {

    @Override
    public void connect() {
    }

    @Override
    public void read() {
    }

    @Override
    public void write() {
    }

    @Override
    public void joinTables() throws Exception {
        throw new Exception("Mongo doesn't have tables!");
    }
}