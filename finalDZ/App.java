import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Infrastructure infrastructure = new Infrastructure();
        // System.out.println(infrastructure.getAllInfo(1));
        // System.out.println(infrastructure.getName(2));
        // System.out.println(infrastructure.getName(3));
        // System.out.println(infrastructure.getName(4));
        infrastructure.findAll("ос"); // функция ищет и выводит в консоль все названия фильмов в которых есть
                                      // пересечение с посылаемой строкой , если нет совпадений то пишет нет
                                      // совпадений
    }
}

class Infrastructure {
    public void findAll(String a) {
        Infrastructure infrastructure = new Infrastructure();
        String b = "";
        boolean flag = false;
        for (int i = 1; i <= db.films.size(); i++) {
            b = infrastructure.getName(i);
            if (b.toLowerCase().indexOf(a.toLowerCase()) >= 0) {
                System.out.println(infrastructure.getName(i));
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("нет совпадений");
        }
    }

    public Infrastructure() {
        init();
    }

    Db db;

    public Db getDb() {
        return db;
    }

    public String getName(int idCinema) {

        Cinema c = db.films.get(idCinema - 1);
        return String.format("%s", c.name);
    }

    public String getAllInfo(int idCinema) {

        Cinema c = db.films.get(idCinema - 1);

        return String.format("%d %s %s %s",
                c.id,
                c.name,
                db.genres.get(c.ganre - 1).name,
                db.prod.get(c.filmProd - 1).titleName);
    }

    Db init() {
        db = new Db();
        // Cinema c1 = new Cinema(); // если конструктор не прописан обявление
        // происходит так
        // c1.id = 1;
        // c1.name = "Тьма";
        // c1.ganre = 1;
        // c1.filmProd = 2;
        Cinema c1 = new Cinema(1, "Тьма", 1, 4);
        Cinema c2 = new Cinema(2, "Свет", 2, 1);
        Cinema c3 = new Cinema(3, "Особенности нац...", 3, 2);
        Cinema c4 = new Cinema(4, "Человек Паук", 3, 3);

        db.films.add(c1);
        db.films.add(c2);
        db.films.add(c3);
        db.films.add(c4);
        // db.films.add(new Cinema(4, "Человек Паук", 1, 3)); при наличии коструктора
        // можно не класть в переменную экземпляр а сразу отправлять в колекцию

        db.genres.add(new Genre(1, "Ужасы"));
        db.genres.add(new Genre(2, "Драма"));
        db.genres.add(new Genre(3, "Комедия"));

        // db.addFilmProducer(FilmProducerFactory.getFilmProducer("Ленфильм"));
        // //внесение через автоматическое назначение id. если FilmProducer и count
        // указан как static
        FilmProducerFactory pf = new FilmProducerFactory();
        db.addFilmProducer(pf.getFilmProducer("Ленфильм"));
        db.addFilmProducer(pf.getFilmProducer("Мосфильм"));
        db.addFilmProducer(pf.getFilmProducer("Marvel"));
        db.addFilmProducer(pf.getFilmProducer("DC"));

        return db;

    }
}

class Db {
    ArrayList<Cinema> films = new ArrayList<>(); // коллекция
    ArrayList<FilmProducer> prod = new ArrayList<>();
    ArrayList<Genre> genres = new ArrayList<>();
    // ArrayList<ResultFind> find = new ArrayList<>();

    public void addFilmProducer(FilmProducer producer) { // прослойка для заполнения колекции чтобы изолировать базы
                                                         // данных от прямого доступа
        prod.add(producer);
    }
}

class Cinema {
    int id;
    int filmProd;
    String name;
    int ganre;

    public Cinema(int id, String name, int ganre, int filmProd) {
        this.id = id;
        this.filmProd = filmProd;
        this.name = name;
        this.ganre = ganre;
    }

}

class FilmProducer {
    int id;
    String titleName;
}

class Genre {
    int id;
    String name;

    public Genre(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class FilmProducerFactory { // клас и метод для автоматического заполнения базы киностудий id присваивается
                            // автоматически нужно пробросить только название
    int count = 1;

    FilmProducer getFilmProducer(String name) {
        FilmProducer fp = new FilmProducer();
        fp.id = count++;
        fp.titleName = name;
        return fp;
    }
}

// class ResultFind{
// String findFilm;

// public void finResultFind(int idCinema) {
// Db db;
// db = new Db();
// Cinema c = db.films.get(idCinema);

// this.findFilm = String.format("%d %s %s %s",
// c.id,
// c.name,
// db.genres.get(c.ganre).name,
// db.prod.get(c.filmProd).titleName);

// }
// }

// // дописать метод который создает новую колекцию и
// // строками туда записывает все что нашел по поисковому
// // запросу и выводит на экран