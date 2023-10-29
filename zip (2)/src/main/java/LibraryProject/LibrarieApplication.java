package LibraryProject;

import LibraryProject.model.Book;
import LibraryProject.model.Comment;
import LibraryProject.model.CommentType;
import LibraryProject.repository.BookRepository;
import LibraryProject.repository.CommentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

import static java.awt.SystemColor.text;
import static javax.swing.text.html.HTML.Attribute.N;
import static org.apache.coyote.http11.Constants.a;
import static org.hibernate.engine.jdbc.Size.LobMultiplier.G;

@SpringBootApplication
public class LibrarieApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibrarieApplication.class, args);
	}

	@Bean
	CommandLineRunner atStartup(BookRepository bookRepository,
								CommentRepository commentRepository) {
		return args -> {
			Comment c1 = new Comment(null, CommentType.TEMASIVIZUNE,
					"Temă și viziune în „Plumb”\n" +
							"George Bacovia este considerat de critica literară cel mai însemnat reprezentant al simbolismului în literatura română. Poet simbolist apreciat pentru originalitatea sa, creează o lirică a tristeții ireparabile.\n" +
							"Poezia simbolistă „Plumb” de G. Bacovia deschide volumul cu același titlu, apărut în 1916, și îl definește. Așezarea sa în fruntea primului volum publicat de Bacovia îi conferă calitatea de text programatic.\n" +
							"Simbolismul este mișcarea artistică și literară de la sfârșitul secolului al XIX-lea, care se opune romantismului, naturalismului și parnasianismului, și potrivit căreia valoarea fiecărui obiect și fenomen din lumea înconjurătoare poate fi exprimată și descifrată cu ajutorul simbolurilor.\n" +
							"Textul poetic se înscrie în estetica simbolistă prin temă și motive, prin cultivarea simbolului, a sugestiei, prin corespondențe, decor, cromatică, tehnica repetițiilor, ce conferă poeziei muzicalitate. Dramatismul este sugerat prin corespondența ce se stabilește între materie și spirit. Textul nu cuprinde niciun termen explicit al angoasei (sentimentul de înstrăinare); starea poetică simbolistă este transmisă pe calea sugestiei, prin decor și simboluri.\n" +
							"Poezia este o elegie, deoarece exprimă sentimentul de tristețe și spaima de moarte, sub forma monologului liric al unui eu „fantomatic” (N. Manolescu).\n" +
							"Tema poeziei este condiția poetului izolat într-o societate lipsită de aspirații, condiție marcată de singurătate, de imposibilitatea comunicării și a evadării, și de moartea iubirii.\n" +
							"Motivele lirice cu valoare de simbol aparțin câmpului semantic al morții: plumbul, cimitirul, sicriele, cavoul, somnul, vântul, frigul, și configurează decorul funerar. Ele se asociază cu stări sufletești nelămurite, confuze, care constituie obiectul poeziei simboliste: singurătatea, izolarea, spaima de moarte, angoasa, spleenul, tragicul existențial etc. Laitmotivul „stam singur” subliniază senzația de pustiire sufletească.\n" +
							"În prima strofă, eul apare în ipostaza însinguratului, într-o lume pustie și moartă: „Stam singur în cavou... și era vânt”. Condiția poetului damnat din cauza imposibilității comunicării cu lumea exterioară se amplifică în strofa a doua și devine incomunicare în plan interior, sufletesc.\n" +
							"În strofa a doua, moartea iubirii acutizează angoasa și sentimentul de singurătate. Dacă la romantici iubirea poate fi o cale de împlinire, la Bacovia moartea amorului sugerează pierderea ultimei speranțe de salvare. Acesta este și motivul pentru care exteriorizarea spaimei de neant se face prin strigăt: „și-am început să-l strig”.\n" +
							"Titlul poeziei „Plumb” este un simbol recurent repetat de șase ori simetric, ceea ce conferă muzicalitate textului, exprimă corespondența dintre un element al naturii și stările sufletești exprimate liric. În sens denotativ, plumbul este un element chimic, un metal moale, maleabil, de culoare cenușiu-albăstruie. Sensul conotativ derivă din cel propriu și sugerează în plan poetic apăsarea, monotonia, dezorientarea, claustrarea.\n" +
							"Lirismul subiectiv este redat prin mărcile eului liric, verbe și pronume la persoana I singular: „stam”, „am început”, „(amorul) meu”. Verbul la imperfect însoțit de epitet „stam singur” exprimă ideea de continuitate a stării de singurătate, în timp ce verbul la perfect compus „am început” urmat de conjunctivul „să strig” exprimă incapacitatea de a comunica sensibil cu iubirea, de unde spaima de neant.\n" +
							"Elemente de prozodie. În ceea de privește prozodia, „Plumb” are o construcție sobră, riguroasă, care sugerează angoasa și imposibilitatea salvării. Elementele prozodiei clasice produc muzicalitatea exterioară, prin rima îmbrățișată, măsura fixă de zece silabe, alternarea iambului cu amfibrahul. Muzicalitatea interioară, specific simbolistă, se realizează prin sonoritatea dată de consoanele „grele” ale simbolului „plumb”, repetat obsesiv în rimă, dar și în rima interioară, de tehnica repetițiilor, de asonanțe și aliterații, care transformă poezia într-un vaier monoton.\n" +
							"În concluzie, prin atmosferă, muzicalitate, folosirea sugestiei, a simbolului și a corespondențelor, prin prezentarea stărilor sufletești de angoasă, de singurătate, de vid sufletesc, poezia „Plumb” se încadrează în estetica simbolistă.\n"
			);

			Comment c2 = new Comment(null, CommentType.CARACTERIZARE,
					"Temăși viziune în „Moara cu noroc”\n" +
							"Ioan Slavici a fost un scriitor, jurnalist și pedagog român, membru corespondent (din 1882) al Academiei Române. Scriitor afirmat la sfârșitul secolului al XIX-lea, el este unul dintre adepții realismului clasic.\n" +
							"Publicată în 1881 în volumul de debut „Novele din popor”, nuvela realistă, de factură psihologică „Moara cu noroc” devine una dintre scrierile reprezentative pentru viziunea lui Ioan Slavici asupra lumii și asupra vieții satului transilvănean.\n" +
							"Nuvela este o specie a genului epic în proză, cu acțiune mai amplă decât a povestirii, conflict consistent și personaje puține. Acțiunea constă dintr-o intrigă puternică cu un conflict susținut, care focalizează, de regulă, asupra unui personaj principal și are ca scop caracterizarea acestuia.\n" +
							"„Moara cu noroc” de Ioan Slavici este o nuvelă deoarece prezintă un fir narativ central și o construcție epică riguroasă, cu un conflict concentrat. Personajele relativ puține scot în evidență evoluția personajului principal, puternic individualizat.\n" +
							"Este o nuvelă psihologică deoarece înfățișează frământările de conștiință ale personajului principal, care trăiește un conflict interior, moral și se transformă sufletește, iar analiza se realizează prin tehnici de investigare psihologică: monolog interior, stil indirect liber, scene dialogate, însoțite de notația gesticii și a mimicii.\n" +
							"Este o nuvelă realistă prin: tema familiei și a dorinței de înavuțire, obiectivitatea perspectivei narative, verosimilitatea, prezentarea veridică a societății ardelenești din a doua jumătate a secolului al XIX-lea, tehnica detaliului semnificativ.\n" +
							"Tema. „Moara cu noroc” de Ioan Slavici are ca temă principală consecințele nefaste și dezumanizante ale dorinței de îmbogățire. Acesteia i se adaugă o temă socială (dorința lui Ghiță de a-și schimba statutul social), una moralizatoare (omul să fie mulțumit cu ceea ce are) și alta psihologică (conflictul interior puternic al personajului principal).\n" +
							"O secvență narativă ce ilustrează tema nuvelei este reprezentată de hotărârea lui Ghiță din primul capitol de a-și schimba destinul, dovadă fiind răspunsul categoric pe care i-l dă soacrei sale: „...și să ne punem pe prispa casei la soare, privind eu la Ana, Ana la mine, amândoi la copilaș, iară d-ta la tustrei. Iacă liniștea colibei.”\n" +
							"Hotărâtor în evoluția destinului lui Ghiță este și momentul primei întâlniri cu Lică, întrucât Sămădăul stârnește deopotrivă admirație și teamă în sufletul eroului care va evolua iremediabil spre decădere morală. Momentul suprem însă, al degradării sale morale, este acela când Ghiță, de la complicitate ajunge la crimă și o ucide pe Ana, gest incalificabil, căci vinovat de înstrăinarea Anei este el însuși.\n" +
							"Titlul nuvelei este mai degrabă ironic. Toposul ales, cârciuma numită Moara cu noroc, ajunge să însemne, mai curând, Moara cu ghinion, Moara care aduce nenorocirea, deoarece câștigurile obținute aici ascund nelegiuiri.\n" +
							"Conflict. Fiind o nuvelă psihologică, în „Moara cu noroc” de Ioan Slavici conflictul central este unul moral, psihologic, conflictul interior al protagonistului. Personajul principal, Ghiță, oscilează între dorința de a rămâne om cinstit, pe de o parte, și dorința de a se îmbogăți alături de Lică, pe de altă parte. Conflictul interior se reflectă în plan exterior, în confruntarea dintre cârciumarul Ghiță și Lică Sămădăul.\n" +
							"Acțiunea se desfășoară pe parcursul unui an, între două repere temporale cu valoare religioasă: de la Sfântul Gheorghe până la Paștele din anul următor; apa și focul purifică locul.\n" +
							"●\tExpozițiunea – descrierea drumului care merge la Moara cu noroc și a locului în care se află cârciuma fixează cadrul acțiunii. Ghiță, cizmar sărac, hotărăște să ia în arendă cârciuma pentru a câștiga bani mai mulți și mai repede.\n" +
							"●\tIntriga – apariția lui Lică Sămădăul la Moara cu noroc declanșează în sufletul lui Ghiță conflictul interior, tulburând echilibrul familiei.\n" +
							"●\tDesfășurarea acțiunii – ilustrează procesul înstrăinării cârciumarului față de familie și al dezumanizării provocate de dorința de îmbogățire prin complicitatea cu Lică. Datorită generozității Sămădăului, starea materială a lui Ghiță devine tot mai înfloritoare, numai că Ghiță începe să-și piardă încrederea în sine.\n" +
							"●\tPunctul culminant – ilustrează dezumanizarea lui Ghiță; la sărbătorile Paștelui, Ghiță își aruncă soția în brațele Sămădăului, lăsând-o singură la cârciumă, în timp ce el merge să-l anunțe pe jandarm că Lică are asupra lui bani furați.\n" +
							"●\tDeznodământul – dându-și seama că soția l-a înșelat, Ghiță o ucide pe Ana, fiind la rândul lui omorât de Răuț, din ordinul lui Lică. Un incendiu provocat de oamenii lui Lică mistuie cârciuma de la Moara cu noroc. Nuvela are final demoralizator, iar singurele personaje care supraviețuiesc sunt bătrâna și copiii, ființele morale și inocente. În concluzie, „Moara cu noroc” este o nuvelă realistă – prin temă, tipologia personajelor și stil – și o nuvelă psihologică, pentru că urmărește conflictul interior, frământările în planul conștiinței personajelor.\n"
			);

			List<Comment> comments = new ArrayList<>();
			comments.add(c1);
			comments.add(c2);
			Book b1 = new Book("George Bacovia", "Opere", "Poezii", 1934, comments);
			c1.setBook(b1);
			c2.setBook(b1);

			commentRepository.save(c1);
			commentRepository.save(c2);
			bookRepository.save(b1);




		};
	}

}
