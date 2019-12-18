package com.dicoding.picodiploma.mybottomnavigation;

import com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity.MovieEntity;
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity.TVShowEntity;

import java.util.ArrayList;

public class FakeDataDummy {

    public static ArrayList<MovieEntity> generateDummyMovies() {

        ArrayList<MovieEntity> movies = new ArrayList<>();

        movies.add(new MovieEntity("330457",
                "https://image.tmdb.org/t/p/w185/qdfARIhgpgZOBh3vfNhWS4hmSo3.jpg",
                "Frozen II",
                "Elsa, Anna, Kristoff and Olaf head far into the forest to learn the truth about an ancient mystery of their kingdom.",
                "7.1",
                "2019-11-20"));

        movies.add(new MovieEntity("398978",
                "https://image.tmdb.org/t/p/w185/mbm8k3GFhXS0ROd9AD1gqYbIFbM.jpg",
                "The Irishman",
                "Pennsylvania, 1956. Frank Sheeran, a war veteran of Irish origin who works as a truck driver, accidentally meets mobster Russell Bufalino. Once Frank becomes his trusted man, Bufalino sends him to Chicago with the task of helping Jimmy Hoffa, a powerful union leader related to organized crime, with whom Frank will maintain a close friendship for nearly twenty years.",
                "8.2",
                "2019-11-01"));

        movies.add(new MovieEntity("466272",
                "https://image.tmdb.org/t/p/w185/8j58iEBw9pOXFD2L0nt0ZXeHviB.jpg",
                "Once Upon a Time… in Hollywood",
                "Los Angeles, 1969. TV star Rick Dalton, a struggling actor specialized in westerns, and stuntman Cliff Booth, his best friend, try to survive to a constantly changing movie industry. Dalton is neighbor of the young and promising actress and model Sharon Tate, who has just married the prestigious Polish director Roman Polanski.",
                "7.5",
                "2019-07-25"));

        movies.add(new MovieEntity("645541",
                "https://image.tmdb.org/t/p/w185/4I0CQfnMy6sRR7QhgqsXR16TmIs.jpg",
                "Ellipse",
                "A man and his dog are stranded on a volatile, oval-shaped planet and are forced to adapt and escape before time destroys them both.",
                "3.7",
                "2019-11-05"));

        movies.add(new MovieEntity("474350",
                "https://image.tmdb.org/t/p/w185/zfE0R94v1E8cuKAerbskfD3VfUt.jpg",
                "It Chapter Two",
                "27 years after overcoming the malevolent supernatural entity Pennywise, the former members of the Losers' Club, who have grown up and moved away from Derry, are brought back together by a devastating phone call.",
                "6.8",
                "2019-09-04"));

        movies.add(new MovieEntity("290859",
                "https://image.tmdb.org/t/p/w185/vqzNJRH4YyquRiWxCCOH0aXggHI.jpg",
                "Terminator: Dark Fate",
                "Decades after Sarah Connor prevented Judgment Day, a lethal new Terminator is sent to eliminate the future leader of the resistance. In a fight to save mankind, battle-hardened Sarah Connor teams up with an unexpected ally and an enhanced super soldier to stop the deadliest Terminator yet.",
                "6.3",
                "2019-10-23"));

        movies.add(new MovieEntity("475557",
                "https://image.tmdb.org/t/p/w185/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg",
                "Joker",
                "During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.",
                "8.4",
                "2019-10-02"));

        movies.add(new MovieEntity("522938",
                "https://image.tmdb.org/t/p/w185/kTQ3J8oTTKofAVLYnds2cHUz9KO.jpg",
                "Rambo: Last Blood",
                "After fighting his demons for decades, John Rambo now lives in peace on his family ranch in Arizona, but his rest is interrupted when Gabriela, the granddaughter of his housekeeper María, disappears after crossing the border into Mexico to meet her biological father. Rambo, who has become a true father figure for Gabriela over the years, undertakes a desperate and dangerous journey to find her.",
                "5.9",
                "2019-09-19"));

        movies.add(new MovieEntity("540901",
                "https://image.tmdb.org/t/p/w185/zBhv8rsLOfpFW2M5b6wW78Uoojs.jpg",
                "Hustlers",
                "A crew of savvy former strip club employees band together to turn the tables on their Wall Street clients.",
                "6.2",
                "2019-09-12"));

        movies.add(new MovieEntity("920",
                "https://image.tmdb.org/t/p/w185/jpfkzbIXgKZqCZAkEkFH2VYF63s.jpg",
                "Cars",
                "Lightning McQueen, a hotshot rookie race car driven to succeed, discovers that life is about the journey, not the finish line, when he finds himself unexpectedly detoured in the sleepy Route 66 town of Radiator Springs. On route across the country to the big Piston Cup Championship in California to compete against two seasoned pros, McQueen gets to know the town's offbeat characters.",
                "6.7",
                "2006-06-08"));

        return movies;
    }

    public static ArrayList<TVShowEntity> generateDummyTVShows() {

        ArrayList<TVShowEntity> shows = new ArrayList<>();

        shows.add(new TVShowEntity("82856",
                "https://image.tmdb.org/t/p/w185/BbNvKCuEF4SRzFXR16aK6ISFtR.jpg",
                "The Mandalorian",
                "Set after the fall of the Empire and before the emergence of the First Order, we follow the travails of a lone gunfighter in the outer reaches of the galaxy far from the authority of the New Republic.",
                "7.7",
                "2019-11-12"));

        shows.add(new TVShowEntity("60625",
                "https://image.tmdb.org/t/p/w185/qJdfO3ahgAMf2rcmhoqngjBBZW1.jpg",
                "Rick and Morty",
                "Rick is a mentally-unbalanced but scientifically-gifted old man who has recently reconnected with his family. He spends most of his time involving his young grandson Morty in dangerous, outlandish adventures throughout space and alternate universes. Compounded with Morty's already unstable family life, these events cause Morty much distress at home and school.",
                "8.6",
                "2013-12-02"));

        shows.add(new TVShowEntity("1412",
                "https://image.tmdb.org/t/p/w185/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "5.8",
                "2012-10-10"));

        shows.add(new TVShowEntity("456",
                "https://image.tmdb.org/t/p/w185/yTZQkSsxUFJZJe67IenRM0AEklc.jpg",
                "The Simpsons",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                "7.2",
                "1989-12-17"));

        shows.add(new TVShowEntity("68507",
                "https://image.tmdb.org/t/p/w185/xOjRNnQw5hqR1EULJ2iHkGwJVA4.jpg",
                "His Dark Materials",
                "Lyra is an orphan who lives in a parallel universe in which science, theology and magic are entwined. Lyra's search for a kidnapped friend uncovers a sinister plot involving stolen children, and turns into a quest to understand a mysterious phenomenon called Dust. She is later joined on her journey by Will, a boy who possesses a knife that can cut windows between worlds. As Lyra learns the truth about her parents and her prophesied destiny, the two young people are caught up in a war against celestial powers that ranges across many worlds.",
                "7.9",
                "2019-11-03"));

        shows.add(new TVShowEntity("71641",
                "https://image.tmdb.org/t/p/w185/jVObyxtNxuPbG5czuKvm7pW56EV.jpg",
                "4 Blocks",
                "Based in Neukölln, Berlin Toni manages the daily business of dealing with the Arabic gangs and ends up wanting to leave his old life behind for his family, but as expected, its never that simple.",
                "4.4",
                "2017-05-08"));

        shows.add(new TVShowEntity("1622",
                "https://image.tmdb.org/t/p/w185/KoYWXbnYuS3b0GyQPkbuexlVK9.jpg",
                "Supernatural",
                "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way. ",
                "7.4",
                "2005-09-13"));

        shows.add(new TVShowEntity("60735",
                "https://image.tmdb.org/t/p/w185/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg",
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "6.7",
                "2014-10-07"));

        shows.add(new TVShowEntity("1402",
                "ttps://image.tmdb.org/t/p/w185/reKs8y4mPwPkZG99ZpbKRhBPKsX.jpg",
                "The Walking Dead",
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                "7.3",
                "2010-10-31"));

        shows.add(new TVShowEntity("2734",
                "https://image.tmdb.org/t/p/w185/6t6r1VGQTTQecN4V0sZeqsmdU9g.jpg",
                "Law & Order: Special Victims Unit",
                "In equal parts high-concept thriller and coming-of-age drama, HANNA follows the journey of an extraordinary young girl raised in the forest, as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is.",
                "6.5",
                "1999-09-20"));

        return shows;
    }

    public static MovieEntity getMovie(String movieId) {
        for (int i = 0; i < generateDummyMovies().size(); i++) {
            MovieEntity movie = generateDummyMovies().get(i);
            if (movie.getId().equals(movieId)) {
                return movie;
            }
        }
        return null;
    }

    public static TVShowEntity getShow(String showId) {
        for (int i = 0; i < generateDummyTVShows().size(); i++) {
            TVShowEntity show = generateDummyTVShows().get(i);
            if (show.getId().equals(showId)) {
                return show;
            }
        }
        return null;
    }
}
