package com.orangesummer.mathgenealogy.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2023/4/3
 */
public class Constant {
    // 图中方向
    public static final Integer DIRECTION_LEFT = 1;
    public static final Integer DIRECTION_RIGHT = 2;

    private static final String[] CLASSIFICATION = new String[]{
            "General",
            "History and biography",
            "",
            "Mathematical logic and foundations",
            "This section has been deleted",
            "Combinatorics",
            "Order, lattices, ordered algebraic structures",
            "",
            "General algebraic systems",
            "",
            "",
            "Number theory",
            "Field theory and polynomials",
            "Commutative rings and algebras",
            "Algebraic geometry",
            "Linear and multilinear algebra; matrix theory",
            "Associative rings and algebras",
            "Nonassociative rings and algebras",
            "Category theory; homological algebra",
            "K-theory",
            "Group theory and generalizations",
            "",
            "Topological groups, Lie groups",
            "",
            "",
            "",
            "Real functions",
            "",
            "Measure and integration",
            "",
            "Functions of a complex variable",
            "Potential theory",
            "Several complex variables and analytic spaces",
            "Special functions",
            "Ordinary differential equations",
            "Partial differential equations",
            "",
            "Dynamical systems and ergodic theory",
            "",
            "Difference and functional equations",
            "Sequences, series, summability",
            "Approximations and expansions",
            "Fourier analysis",
            "Abstract harmonic analysis",
            "Integral transforms, operational calculus",
            "Integral equations",
            "Functional analysis",
            "Operator theory",
            "",
            "Calculus of variations and optimal control; optimization",
            "",
            "Geometry",
            "Convex and discrete geometry",
            "Differential geometry",
            "General topology",
            "Algebraic topology",
            "",
            "Manifolds and cell complexes",
            "Global analysis, analysis on manifolds",
            "",
            "Probability theory and stochastic processes",
            "",
            "Statistics",
            "",
            "",
            "Numerical analysis",
            "",
            "",
            "Computer science",
            "",
            "Mechanics of particles and systems",
            "",
            "",
            "This section has been deleted",
            "Mechanics of deformable solids",
            "",
            "Fluid mechanics",
            "",
            "Optics, electromagnetic theory",
            "",
            "Classical thermodynamics, heat transfer",
            "Quantum theory",
            "Statistical mechanics, structure of matter",
            "Relativity and gravitational theory",
            "",
            "Astronomy and astrophysics",
            "Geophysics",
            "",
            "",
            "",
            "Operations research, mathematical programming",
            "Game theory, economics, social and behavioral sciences",
            "Biology and other natural sciences",
            "Systems theory; control",
            "Information and communication, circuits",
            "",
            "",
            "Mathematics education"
    };

    public static final List<String> CLASSIFICATIONARRAY = List.of(CLASSIFICATION);

    public static final Map<String, Double> COUNTRYLON = new HashMap<>();

    static {
        COUNTRYLON.put("Andorra", 1.601554);
        COUNTRYLON.put("UnitedArabEmirates", 53.847818);
        COUNTRYLON.put("Afghanistan", 67.709953);
        COUNTRYLON.put("Antigua and Barbuda	", -61.796428);
        COUNTRYLON.put("Anguilla", -63.068615);
        COUNTRYLON.put("Albania", 20.168331);
        COUNTRYLON.put("Armenia", 45.038189);
        COUNTRYLON.put("Netherlands Antilles", -69.060087);
        COUNTRYLON.put("Angola", 17.873887);
        COUNTRYLON.put("Antarctica", -0.071389);
        COUNTRYLON.put("Argentina", -63.616672);
        COUNTRYLON.put("American Samoa", -170.132217);
        COUNTRYLON.put("Austria", 14.550072);
        COUNTRYLON.put("Australia", 133.775136);
        COUNTRYLON.put("Aruba", -69.968338);
        COUNTRYLON.put("Azerbaijan", 47.576927);
        COUNTRYLON.put("BosniaHerzegovina", 17.679076);
        COUNTRYLON.put("Barbados", -59.543198);
        COUNTRYLON.put("Bangladesh", 90.356331);
        COUNTRYLON.put("Belgium", 4.469936);
        COUNTRYLON.put("Burkina Faso", -1.561593);
        COUNTRYLON.put("Bulgaria", 25.48583);
        COUNTRYLON.put("Bahrain", 50.637772);
        COUNTRYLON.put("Burundi", 29.918886);
        COUNTRYLON.put("Benin", 2.315834);
        COUNTRYLON.put("Bermuda", -64.75737);
        COUNTRYLON.put("Brunei", 114.727669);
        COUNTRYLON.put("Bolivia", -63.588653);
        COUNTRYLON.put("Brazil", -51.92528);
        COUNTRYLON.put("Bahamas", -77.39628);
        COUNTRYLON.put("Bhutan", 90.433601);
        COUNTRYLON.put("Bouvet Island", 3.413194);
        COUNTRYLON.put("Botswana", 24.684866);
        COUNTRYLON.put("Belarus", 27.953389);
        COUNTRYLON.put("Belize", -88.49765);
        COUNTRYLON.put("Canada", -106.346771);
        COUNTRYLON.put("Cocos [Keeling] Islands", 96.870956);
        COUNTRYLON.put("DemocraticRepublicOfTheCongo", 21.758664);
        COUNTRYLON.put("Central African Republic", 20.939444);
        COUNTRYLON.put("Congo-Brazzaville", 15.827659);
        COUNTRYLON.put("Switzerland", 8.227512);
        COUNTRYLON.put("Coted'Ivoire", -5.54708);
        COUNTRYLON.put("Cook Islands", -159.777671);
        COUNTRYLON.put("Chile", -71.542969);
        COUNTRYLON.put("Cameroon", 12.354722);
        COUNTRYLON.put("China", 104.195397);
        COUNTRYLON.put("HongKong", 104.195397);
        COUNTRYLON.put("Macao", 104.195397);
        COUNTRYLON.put("Colombia", -74.297333);
        COUNTRYLON.put("Costa Rica", -83.753428);
        COUNTRYLON.put("Cuba", -77.781167);
        COUNTRYLON.put("Cape Verde", -24.013197);
        COUNTRYLON.put("Christmas Island", 105.690449);
        COUNTRYLON.put("Cyprus", 33.429859);
        COUNTRYLON.put("CzechRepublic", 15.472962);
        COUNTRYLON.put("Germany", 10.451526);
        COUNTRYLON.put("Djibouti", 42.590275);
        COUNTRYLON.put("Denmark", 9.501785);
        COUNTRYLON.put("Dominica", -61.370976);
        COUNTRYLON.put("Dominican Republic", -70.162651);
        COUNTRYLON.put("Algeria", 1.659626);
        COUNTRYLON.put("Ecuador", -78.183406);
        COUNTRYLON.put("Estonia", 25.013607);
        COUNTRYLON.put("Egypt", 30.802498);
        COUNTRYLON.put("Western Sahara", -12.885834);
        COUNTRYLON.put("Eritrea", 39.782334);
        COUNTRYLON.put("Spain", -3.74922);
        COUNTRYLON.put("Ethiopia", 40.489673);
        COUNTRYLON.put("Finland", 25.748151);
        COUNTRYLON.put("Fiji", 179.414413);
        COUNTRYLON.put("Falkland Islands [Islas Malvinas]", -59.523613);
        COUNTRYLON.put("Micronesia", 150.550812);
        COUNTRYLON.put("Faroe Islands", -6.911806);
        COUNTRYLON.put("France", 2.213749);
        COUNTRYLON.put("Gabon", 11.609444);
        COUNTRYLON.put("UnitedKingdom", -3.435973);
        COUNTRYLON.put("Scotland", -3.435973);
        COUNTRYLON.put("Grenada", -61.604171);
        COUNTRYLON.put("Georgia", 43.356892);
        COUNTRYLON.put("French Guiana", -53.125782);
        COUNTRYLON.put("Guernsey", -2.585278);
        COUNTRYLON.put("Ghana", -1.023194);
        COUNTRYLON.put("Gibraltar", -5.345374);
        COUNTRYLON.put("Greenland", -42.604303);
        COUNTRYLON.put("Gambia", -15.310139);
        COUNTRYLON.put("Guinea", -9.696645);
        COUNTRYLON.put("Guadeloupe", -62.067641);
        COUNTRYLON.put("Equatorial Guinea", 10.267895);
        COUNTRYLON.put("Greece", 21.824312);
        COUNTRYLON.put("South Georgia and the South Sandwich Islands", -36.587909);
        COUNTRYLON.put("Guatemala", -90.230759);
        COUNTRYLON.put("Guam", 144.793731);
        COUNTRYLON.put("Guinea-Bissau", -15.180413);
        COUNTRYLON.put("Guyana", -58.93018);
        COUNTRYLON.put("Gaza Strip", 34.308825);
        COUNTRYLON.put("Hong Kong", 114.109497);
        COUNTRYLON.put("Heard Island and McDonald Islands", 73.504158);
        COUNTRYLON.put("Honduras", -86.241905);
        COUNTRYLON.put("Croatia", 15.2);
        COUNTRYLON.put("Haiti", -72.285215);
        COUNTRYLON.put("Hungary", 19.503304);
        COUNTRYLON.put("Indonesia", 113.921327);
        COUNTRYLON.put("Ireland", -8.24389);
        COUNTRYLON.put("Israel", 34.851612);
        COUNTRYLON.put("Isle of Man", -4.548056);
        COUNTRYLON.put("India", 78.96288);
        COUNTRYLON.put("British Indian Ocean Territory", 71.876519);
        COUNTRYLON.put("Iraq", 43.679291);
        COUNTRYLON.put("Iran", 53.688046);
        COUNTRYLON.put("Iceland", -19.020835);
        COUNTRYLON.put("Italy", 12.56738);
        COUNTRYLON.put("Jersey", -2.13125);
        COUNTRYLON.put("Jamaica", -77.297508);
        COUNTRYLON.put("Jordan", 36.238414);
        COUNTRYLON.put("Japan", 138.252924);
        COUNTRYLON.put("Kenya", 37.906193);
        COUNTRYLON.put("Kyrgyzstan", 74.766098);
        COUNTRYLON.put("Cambodia", 104.990963);
        COUNTRYLON.put("Kiribati", -168.734039);
        COUNTRYLON.put("Comoros", 43.872219);
        COUNTRYLON.put("Saint Kitts and Nevis", -62.782998);
        COUNTRYLON.put("North Korea", 127.510093);
        COUNTRYLON.put("SouthKorea", 127.766922);
        COUNTRYLON.put("Kuwait", 47.481766);
        COUNTRYLON.put("Cayman Islands", -80.566956);
        COUNTRYLON.put("Kazakhstan", 66.923684);
        COUNTRYLON.put("Laos", 102.495496);
        COUNTRYLON.put("Lebanon", 35.862285);
        COUNTRYLON.put("Saint Lucia", -60.978893);
        COUNTRYLON.put("Liechtenstein", 9.555373);
        COUNTRYLON.put("Sri Lanka", 80.771797);
        COUNTRYLON.put("Liberia", -9.429499);
        COUNTRYLON.put("Lesotho", 28.233608);
        COUNTRYLON.put("Lithuania", 23.881275);
        COUNTRYLON.put("Luxembourg", 6.129583);
        COUNTRYLON.put("Latvia", 24.603189);
        COUNTRYLON.put("Libya", 17.228331);
        COUNTRYLON.put("Morocco", -7.09262);
        COUNTRYLON.put("Monaco", 7.412841);
        COUNTRYLON.put("Moldova", 28.369885);
        COUNTRYLON.put("Montenegro", 19.37439);
        COUNTRYLON.put("Madagascar", 46.869107);
        COUNTRYLON.put("Marshall Islands", 171.184478);
        COUNTRYLON.put("Macedonia", 21.745275);
        COUNTRYLON.put("Mali", -3.996166);
        COUNTRYLON.put("Myanmar [Burma]", 95.956223);
        COUNTRYLON.put("Mongolia", 103.846656);
        COUNTRYLON.put("Macau", 113.543873);
        COUNTRYLON.put("Northern Mariana Islands", 145.38469);
        COUNTRYLON.put("Martinique", -61.024174);
        COUNTRYLON.put("Mauritania", -10.940835);
        COUNTRYLON.put("Montserrat", -62.187366);
        COUNTRYLON.put("Malta", 14.375416);
        COUNTRYLON.put("Mauritius", 57.552152);
        COUNTRYLON.put("Maldives", 73.22068);
        COUNTRYLON.put("Malawi", 34.301525);
        COUNTRYLON.put("Mexico", -102.552784);
        COUNTRYLON.put("Malaysia", 101.975766);
        COUNTRYLON.put("Mozambique", 35.529562);
        COUNTRYLON.put("Namibia", 18.49041);
        COUNTRYLON.put("New Caledonia", 165.618042);
        COUNTRYLON.put("Niger", 8.081666);
        COUNTRYLON.put("Norfolk Island", 167.954712);
        COUNTRYLON.put("Nigeria", 8.675277);
        COUNTRYLON.put("Nicaragua", -85.207229);
        COUNTRYLON.put("Netherlands", 5.291266);
        COUNTRYLON.put("Norway", 8.468946);
        COUNTRYLON.put("Nepal", 84.124008);
        COUNTRYLON.put("Nauru", 166.931503);
        COUNTRYLON.put("Niue", -169.867233);
        COUNTRYLON.put("NewZealand", 174.885971);
        COUNTRYLON.put("Oman", 55.923255);
        COUNTRYLON.put("Panama", -80.782127);
        COUNTRYLON.put("Peru", -75.015152);
        COUNTRYLON.put("French Polynesia", -149.406843);
        COUNTRYLON.put("Papua New Guinea", 143.95555);
        COUNTRYLON.put("Philippines", 121.774017);
        COUNTRYLON.put("Pakistan", 69.345116);
        COUNTRYLON.put("Poland", 19.145136);
        COUNTRYLON.put("Saint Pierre and Miquelon", -56.27111);
        COUNTRYLON.put("Pitcairn Islands", -127.439308);
        COUNTRYLON.put("Puerto Rico", -66.590149);
        COUNTRYLON.put("Palestinian Territories", 35.233154);
        COUNTRYLON.put("Portugal", -8.224454);
        COUNTRYLON.put("Palau", 134.58252);
        COUNTRYLON.put("Paraguay", -58.443832);
        COUNTRYLON.put("Qatar", 51.183884);
        COUNTRYLON.put("Réunion", 55.536384);
        COUNTRYLON.put("Romania", 24.96676);
        COUNTRYLON.put("Serbia", 21.005859);
        COUNTRYLON.put("Yugoslavia", 21.005859);
        COUNTRYLON.put("Russia", 105.318756);
        COUNTRYLON.put("Rwanda", 29.873888);
        COUNTRYLON.put("SaudiArabia", 45.079162);
        COUNTRYLON.put("Solomon Islands", 160.156194);
        COUNTRYLON.put("Seychelles", 55.491977);
        COUNTRYLON.put("Sudan", 30.217636);
        COUNTRYLON.put("Sweden", 18.643501);
        COUNTRYLON.put("Singapore", 103.819836);
        COUNTRYLON.put("Saint Helena", -10.030696);
        COUNTRYLON.put("Slovenia", 14.995463);
        COUNTRYLON.put("Svalbard and Jan Mayen", 23.670272);
        COUNTRYLON.put("Slovakia", 19.699024);
        COUNTRYLON.put("Sierra Leone", -11.779889);
        COUNTRYLON.put("San Marino", 12.457777);
        COUNTRYLON.put("Senegal", -14.452362);
        COUNTRYLON.put("Somalia", 46.199616);
        COUNTRYLON.put("Suriname", -56.027783);
        COUNTRYLON.put("São Tomé and Príncipe", 6.613081);
        COUNTRYLON.put("El Salvador", -88.89653);
        COUNTRYLON.put("Syria", 38.996815);
        COUNTRYLON.put("Swaziland", 31.465866);
        COUNTRYLON.put("Turks and Caicos Islands", -71.797928);
        COUNTRYLON.put("Chad", 18.732207);
        COUNTRYLON.put("French Southern Territories", 69.348557);
        COUNTRYLON.put("Togo", 0.824782);
        COUNTRYLON.put("Thailand", 100.992541);
        COUNTRYLON.put("Tajikistan", 71.276093);
        COUNTRYLON.put("Tokelau", -171.855881);
        COUNTRYLON.put("Timor-Leste", 125.727539);
        COUNTRYLON.put("Turkmenistan", 59.556278);
        COUNTRYLON.put("Tunisia", 9.537499);
        COUNTRYLON.put("Tonga", -175.198242);
        COUNTRYLON.put("Turkey", 35.243322);
        COUNTRYLON.put("TrinidadTobago", -61.222503);
        COUNTRYLON.put("Tuvalu", 177.64933);
        COUNTRYLON.put("Taiwan", 120.960515);
        COUNTRYLON.put("Tanzania", 34.888822);
        COUNTRYLON.put("Ukraine", 31.16558);
        COUNTRYLON.put("Uganda", 32.290275);
        COUNTRYLON.put("U.S. Minor Outlying Islands", (double) 0);
        COUNTRYLON.put("UnitedStates", -95.712891);
        COUNTRYLON.put("Uruguay", -55.765835);
        COUNTRYLON.put("Uzbekistan", 64.585262);
        COUNTRYLON.put("Vatican City", 12.453389);
        COUNTRYLON.put("Saint Vincent and the Grenadines", -61.287228);
        COUNTRYLON.put("Venezuela", -66.58973);
        COUNTRYLON.put("British Virgin Islands", -64.639968);
        COUNTRYLON.put("U.S. Virgin Islands", -64.896335);
        COUNTRYLON.put("Vietnam", 108.277199);
        COUNTRYLON.put("Vanuatu", 166.959158);
        COUNTRYLON.put("Wallis and Futuna", -177.156097);
        COUNTRYLON.put("Samoa", -172.104629);
        COUNTRYLON.put("Kosovo", 20.902977);
        COUNTRYLON.put("Yemen", 48.516388);
        COUNTRYLON.put("Mayotte", 45.166244);
        COUNTRYLON.put("SouthAfrica", 22.937506);
        COUNTRYLON.put("Zambia", 27.849332);
        COUNTRYLON.put("Zimbabwe", 29.154857);
    }

    public static final Map<String, Double> COUNTRYLAT = new HashMap<>();

    static {
        COUNTRYLAT.put("Andorra", 42.546245);
        COUNTRYLAT.put("UnitedArabEmirates", 23.424076);
        COUNTRYLAT.put("Afghanistan", 33.93911);
        COUNTRYLAT.put("Antigua and Barbuda	", 17.060816);
        COUNTRYLAT.put("Anguilla", 18.220554);
        COUNTRYLAT.put("Albania", 41.153332);
        COUNTRYLAT.put("Armenia", 40.069099);
        COUNTRYLAT.put("Netherlands Antilles", 12.226079);
        COUNTRYLAT.put("Angola", -11.202692);
        COUNTRYLAT.put("Antarctica", -75.250973);
        COUNTRYLAT.put("Argentina", -38.416097);
        COUNTRYLAT.put("American Samoa", -14.270972);
        COUNTRYLAT.put("Austria", 47.516231);
        COUNTRYLAT.put("Australia", -25.274398);
        COUNTRYLAT.put("Aruba", 12.52111);
        COUNTRYLAT.put("Azerbaijan", 40.143105);
        COUNTRYLAT.put("BosniaHerzegovina", 43.915886);
        COUNTRYLAT.put("Barbados", 13.193887);
        COUNTRYLAT.put("Bangladesh", 23.684994);
        COUNTRYLAT.put("Belgium", 50.503887);
        COUNTRYLAT.put("Burkina Faso", 12.238333);
        COUNTRYLAT.put("Bulgaria", 42.733883);
        COUNTRYLAT.put("Bahrain", 25.930414);
        COUNTRYLAT.put("Burundi", -3.373056);
        COUNTRYLAT.put("Benin", 9.30769);
        COUNTRYLAT.put("Bermuda", 32.321384);
        COUNTRYLAT.put("Brunei", 4.535277);
        COUNTRYLAT.put("Bolivia", -16.290154);
        COUNTRYLAT.put("Brazil", -14.235004);
        COUNTRYLAT.put("Bahamas", 25.03428);
        COUNTRYLAT.put("Bhutan", 27.514162);
        COUNTRYLAT.put("Bouvet Island", -54.423199);
        COUNTRYLAT.put("Botswana", -22.328474);
        COUNTRYLAT.put("Belarus", 53.709807);
        COUNTRYLAT.put("Belize", 17.189877);
        COUNTRYLAT.put("Canada", 56.130366);
        COUNTRYLAT.put("Cocos [Keeling] Islands", -12.164165);
        COUNTRYLAT.put("DemocraticRepublicOfTheCongo", -4.038333);
        COUNTRYLAT.put("Central African Republic", 6.611111);
        COUNTRYLAT.put("Congo-Brazzaville", -0.228021);
        COUNTRYLAT.put("Switzerland", 46.818188);
        COUNTRYLAT.put("Coted'Ivoire", 7.539989);
        COUNTRYLAT.put("Cook Islands", -21.236736);
        COUNTRYLAT.put("Chile", -35.675147);
        COUNTRYLAT.put("Cameroon", 7.369722);
        COUNTRYLAT.put("China", 35.86166);
        COUNTRYLAT.put("HongKong", 35.86166);
        COUNTRYLAT.put("Macao", 35.86166);
        COUNTRYLAT.put("Colombia", 4.570868);
        COUNTRYLAT.put("Costa Rica", 9.748917);
        COUNTRYLAT.put("Cuba", 21.521757);
        COUNTRYLAT.put("Cape Verde", 16.002082);
        COUNTRYLAT.put("Christmas Island", -10.447525);
        COUNTRYLAT.put("Cyprus", 35.126413);
        COUNTRYLAT.put("CzechRepublic", 49.817492);
        COUNTRYLAT.put("Germany", 51.165691);
        COUNTRYLAT.put("Djibouti", 11.825138);
        COUNTRYLAT.put("Denmark", 56.26392);
        COUNTRYLAT.put("Dominica", 15.414999);
        COUNTRYLAT.put("Dominican Republic", 18.735693);
        COUNTRYLAT.put("Algeria", 28.033886);
        COUNTRYLAT.put("Ecuador", -1.831239);
        COUNTRYLAT.put("Estonia", 58.595272);
        COUNTRYLAT.put("Egypt", 26.820553);
        COUNTRYLAT.put("Western Sahara", 24.215527);
        COUNTRYLAT.put("Eritrea", 15.179384);
        COUNTRYLAT.put("Spain", 40.463667);
        COUNTRYLAT.put("Ethiopia", 9.145);
        COUNTRYLAT.put("Finland", 61.92411);
        COUNTRYLAT.put("Fiji", -16.578193);
        COUNTRYLAT.put("Falkland Islands [Islas Malvinas]", -51.796253);
        COUNTRYLAT.put("Micronesia", 7.425554);
        COUNTRYLAT.put("Faroe Islands", 61.892635);
        COUNTRYLAT.put("France", 46.227638);
        COUNTRYLAT.put("Gabon", -0.803689);
        COUNTRYLAT.put("UnitedKingdom", 55.378051);
        COUNTRYLAT.put("Scotland", 55.378051);
        COUNTRYLAT.put("Grenada", 12.262776);
        COUNTRYLAT.put("Georgia", 42.315407);
        COUNTRYLAT.put("French Guiana", 3.933889);
        COUNTRYLAT.put("Guernsey", 49.465691);
        COUNTRYLAT.put("Ghana", 7.946527);
        COUNTRYLAT.put("Gibraltar", 36.137741);
        COUNTRYLAT.put("Greenland", 71.706936);
        COUNTRYLAT.put("Gambia", 13.443182);
        COUNTRYLAT.put("Guinea", 9.945587);
        COUNTRYLAT.put("Guadeloupe", 16.995971);
        COUNTRYLAT.put("Equatorial Guinea", 1.650801);
        COUNTRYLAT.put("Greece", 39.074208);
        COUNTRYLAT.put("South Georgia and the South Sandwich Islands", -54.429579);
        COUNTRYLAT.put("Guatemala", 15.783471);
        COUNTRYLAT.put("Guam", 13.444304);
        COUNTRYLAT.put("Guinea-Bissau", 11.803749);
        COUNTRYLAT.put("Guyana", 4.860416);
        COUNTRYLAT.put("Gaza Strip", 31.354676);
        COUNTRYLAT.put("Hong Kong", 22.396428);
        COUNTRYLAT.put("Heard Island and McDonald Islands", -53.08181);
        COUNTRYLAT.put("Honduras", 15.199999);
        COUNTRYLAT.put("Croatia", 45.1);
        COUNTRYLAT.put("Haiti", 18.971187);
        COUNTRYLAT.put("Hungary", 47.162494);
        COUNTRYLAT.put("Indonesia", -0.789275);
        COUNTRYLAT.put("Ireland", 53.41291);
        COUNTRYLAT.put("Israel", 31.046051);
        COUNTRYLAT.put("Isle of Man", 54.236107);
        COUNTRYLAT.put("India", 20.593684);
        COUNTRYLAT.put("British Indian Ocean Territory", -6.343194);
        COUNTRYLAT.put("Iraq", 33.223191);
        COUNTRYLAT.put("Iran", 32.427908);
        COUNTRYLAT.put("Iceland", 64.963051);
        COUNTRYLAT.put("Italy", 41.87194);
        COUNTRYLAT.put("Jersey", 49.214439);
        COUNTRYLAT.put("Jamaica", 18.109581);
        COUNTRYLAT.put("Jordan", 30.585164);
        COUNTRYLAT.put("Japan", 36.204824);
        COUNTRYLAT.put("Kenya", -0.023559);
        COUNTRYLAT.put("Kyrgyzstan", 41.20438);
        COUNTRYLAT.put("Cambodia", 12.565679);
        COUNTRYLAT.put("Kiribati", -3.370417);
        COUNTRYLAT.put("Comoros", -11.875001);
        COUNTRYLAT.put("Saint Kitts and Nevis", 17.357822);
        COUNTRYLAT.put("North Korea", 40.339852);
        COUNTRYLAT.put("SouthKorea", 35.907757);
        COUNTRYLAT.put("Kuwait", 29.31166);
        COUNTRYLAT.put("Cayman Islands", 19.513469);
        COUNTRYLAT.put("Kazakhstan", 48.019573);
        COUNTRYLAT.put("Laos", 19.85627);
        COUNTRYLAT.put("Lebanon", 33.854721);
        COUNTRYLAT.put("Saint Lucia", 13.909444);
        COUNTRYLAT.put("Liechtenstein", 47.166);
        COUNTRYLAT.put("Sri Lanka", 7.873054);
        COUNTRYLAT.put("Liberia", 6.428055);
        COUNTRYLAT.put("Lesotho", -29.609988);
        COUNTRYLAT.put("Lithuania", 55.169438);
        COUNTRYLAT.put("Luxembourg", 49.815273);
        COUNTRYLAT.put("Latvia", 56.879635);
        COUNTRYLAT.put("Libya", 26.3351);
        COUNTRYLAT.put("Morocco", 31.791702);
        COUNTRYLAT.put("Monaco", 43.750298);
        COUNTRYLAT.put("Moldova", 47.411631);
        COUNTRYLAT.put("Montenegro", 42.708678);
        COUNTRYLAT.put("Madagascar", -18.766947);
        COUNTRYLAT.put("Marshall Islands", 7.131474);
        COUNTRYLAT.put("Macedonia", 41.608635);
        COUNTRYLAT.put("Mali", 17.570692);
        COUNTRYLAT.put("Myanmar [Burma]", 21.913965);
        COUNTRYLAT.put("Mongolia", 46.862496);
        COUNTRYLAT.put("Macau", 22.198745);
        COUNTRYLAT.put("Northern Mariana Islands", 17.33083);
        COUNTRYLAT.put("Martinique", 14.641528);
        COUNTRYLAT.put("Mauritania", 21.00789);
        COUNTRYLAT.put("Montserrat", 16.742498);
        COUNTRYLAT.put("Malta", 35.937496);
        COUNTRYLAT.put("Mauritius", -20.348404);
        COUNTRYLAT.put("Maldives", 3.202778);
        COUNTRYLAT.put("Malawi", -13.254308);
        COUNTRYLAT.put("Mexico", 23.634501);
        COUNTRYLAT.put("Malaysia", 4.210484);
        COUNTRYLAT.put("Mozambique", -18.665695);
        COUNTRYLAT.put("Namibia", -22.95764);
        COUNTRYLAT.put("New Caledonia", -20.904305);
        COUNTRYLAT.put("Niger", 17.607789);
        COUNTRYLAT.put("Norfolk Island", -29.040835);
        COUNTRYLAT.put("Nigeria", 9.081999);
        COUNTRYLAT.put("Nicaragua", 12.865416);
        COUNTRYLAT.put("Netherlands", 52.132633);
        COUNTRYLAT.put("Norway", 60.472024);
        COUNTRYLAT.put("Nepal", 28.394857);
        COUNTRYLAT.put("Nauru", -0.522778);
        COUNTRYLAT.put("Niue", -19.054445);
        COUNTRYLAT.put("NewZealand", -40.900557);
        COUNTRYLAT.put("Oman", 21.512583);
        COUNTRYLAT.put("Panama", 8.537981);
        COUNTRYLAT.put("Peru", -9.189967);
        COUNTRYLAT.put("French Polynesia", -17.679742);
        COUNTRYLAT.put("Papua New Guinea", -6.314993);
        COUNTRYLAT.put("Philippines", 12.879721);
        COUNTRYLAT.put("Pakistan", 30.375321);
        COUNTRYLAT.put("Poland", 51.919438);
        COUNTRYLAT.put("Saint Pierre and Miquelon", 46.941936);
        COUNTRYLAT.put("Pitcairn Islands", -24.703615);
        COUNTRYLAT.put("Puerto Rico", 18.220833);
        COUNTRYLAT.put("Palestinian Territories", 31.952162);
        COUNTRYLAT.put("Portugal", 39.399872);
        COUNTRYLAT.put("Palau", 7.51498);
        COUNTRYLAT.put("Paraguay", -23.442503);
        COUNTRYLAT.put("Qatar", 25.354826);
        COUNTRYLAT.put("Réunion", -21.115141);
        COUNTRYLAT.put("Romania", 45.943161);
        COUNTRYLAT.put("Serbia", 44.016521);
        COUNTRYLAT.put("Yugoslavia", 44.016521);
        COUNTRYLAT.put("Russia", 61.52401);
        COUNTRYLAT.put("Rwanda", -1.940278);
        COUNTRYLAT.put("SaudiArabia", 23.885942);
        COUNTRYLAT.put("Solomon Islands", -9.64571);
        COUNTRYLAT.put("Seychelles", -4.679574);
        COUNTRYLAT.put("Sudan", 12.862807);
        COUNTRYLAT.put("Sweden", 60.128161);
        COUNTRYLAT.put("Singapore", 1.352083);
        COUNTRYLAT.put("Saint Helena", -24.143474);
        COUNTRYLAT.put("Slovenia", 46.151241);
        COUNTRYLAT.put("Svalbard and Jan Mayen", 77.553604);
        COUNTRYLAT.put("Slovakia", 48.669026);
        COUNTRYLAT.put("Sierra Leone", 8.460555);
        COUNTRYLAT.put("San Marino", 43.94236);
        COUNTRYLAT.put("Senegal", 14.497401);
        COUNTRYLAT.put("Somalia", 5.152149);
        COUNTRYLAT.put("Suriname", 3.919305);
        COUNTRYLAT.put("São Tomé and Príncipe", 0.18636);
        COUNTRYLAT.put("El Salvador", 13.794185);
        COUNTRYLAT.put("Syria", 34.802075);
        COUNTRYLAT.put("Swaziland", -26.522503);
        COUNTRYLAT.put("Turks and Caicos Islands", 21.694025);
        COUNTRYLAT.put("Chad", 15.454166);
        COUNTRYLAT.put("French Southern Territories", -49.280366);
        COUNTRYLAT.put("Togo", 8.619543);
        COUNTRYLAT.put("Thailand", 15.870032);
        COUNTRYLAT.put("Tajikistan", 38.861034);
        COUNTRYLAT.put("Tokelau", -8.967363);
        COUNTRYLAT.put("Timor-Leste", -8.874217);
        COUNTRYLAT.put("Turkmenistan", 38.969719);
        COUNTRYLAT.put("Tunisia", 33.886917);
        COUNTRYLAT.put("Tonga", -21.178986);
        COUNTRYLAT.put("Turkey", 38.963745);
        COUNTRYLAT.put("TrinidadTobago", 10.691803);
        COUNTRYLAT.put("Tuvalu", -7.109535);
        COUNTRYLAT.put("Taiwan", 23.69781);
        COUNTRYLAT.put("Tanzania", -6.369028);
        COUNTRYLAT.put("Ukraine", 48.379433);
        COUNTRYLAT.put("Uganda", 1.373333);
        COUNTRYLAT.put("U.S. Minor Outlying Islands", (double) 0);
        COUNTRYLAT.put("UnitedStates", 37.09024);
        COUNTRYLAT.put("Uruguay", -32.522779);
        COUNTRYLAT.put("Uzbekistan", 41.377491);
        COUNTRYLAT.put("Vatican City", 41.902916);
        COUNTRYLAT.put("Saint Vincent and the Grenadines", 12.984305);
        COUNTRYLAT.put("Venezuela", 6.42375);
        COUNTRYLAT.put("British Virgin Islands", 18.420695);
        COUNTRYLAT.put("U.S. Virgin Islands", 18.335765);
        COUNTRYLAT.put("Vietnam", 14.058324);
        COUNTRYLAT.put("Vanuatu", -15.376706);
        COUNTRYLAT.put("Wallis and Futuna", -13.768752);
        COUNTRYLAT.put("Samoa", -13.759029);
        COUNTRYLAT.put("Kosovo", 42.602636);
        COUNTRYLAT.put("Yemen", 15.552727);
        COUNTRYLAT.put("Mayotte", -12.8275);
        COUNTRYLAT.put("SouthAfrica", -30.559482);
        COUNTRYLAT.put("Zambia", -13.133897);
        COUNTRYLAT.put("Zimbabwe", -19.015438);
    }

    public static final Map<String, Integer> COUNTRYPOPULATION = new HashMap<>();

    static {
        COUNTRYPOPULATION.put("Andorra", 79535);
        COUNTRYPOPULATION.put("UnitedArabEmirates", 9890400);
        COUNTRYPOPULATION.put("Afghanistan", 32890000);
        COUNTRYPOPULATION.put("Antigua and Barbuda	", 96134);
        COUNTRYPOPULATION.put("Anguilla", 16187);
        COUNTRYPOPULATION.put("Albania", 2862400);
        COUNTRYPOPULATION.put("Armenia", 2957500);
        COUNTRYPOPULATION.put("Netherlands Antilles", 566390);
        COUNTRYPOPULATION.put("Angola", 34094000);
        COUNTRYPOPULATION.put("Antarctica", 5000);
        COUNTRYPOPULATION.put("Argentina", 46045000);
        COUNTRYPOPULATION.put("American Samoa", 57100);
        COUNTRYPOPULATION.put("Austria", 9106100);
        COUNTRYPOPULATION.put("Australia", 26326000);
        COUNTRYPOPULATION.put("Aruba", 111840);
        COUNTRYPOPULATION.put("Azerbaijan", 10127000);
        COUNTRYPOPULATION.put("BosniaHerzegovina", 3788100);
        COUNTRYPOPULATION.put("Barbados", 288510);
        COUNTRYPOPULATION.put("Bangladesh", 169830000);
        COUNTRYPOPULATION.put("Belgium", 11739000);
        COUNTRYPOPULATION.put("Burkina Faso", 21509000);
        COUNTRYPOPULATION.put("Bulgaria", 6942100);
        COUNTRYPOPULATION.put("Bahrain", 1592000);
        COUNTRYPOPULATION.put("Burundi", 12575000);
        COUNTRYPOPULATION.put("Benin", 12506000);
        COUNTRYPOPULATION.put("Bermuda", 64027);
        COUNTRYPOPULATION.put("Brunei", 442400);
        COUNTRYPOPULATION.put("Bolivia", 12006000);
        COUNTRYPOPULATION.put("Brazil", 215900000);
        COUNTRYPOPULATION.put("Bahamas", 385340);
        COUNTRYPOPULATION.put("Bhutan", 741670);
        COUNTRYPOPULATION.put("Bouvet Island", 0);
        COUNTRYPOPULATION.put("Botswana", 2338900);
        COUNTRYPOPULATION.put("Belarus", 9255500);
        COUNTRYPOPULATION.put("Belize", 408490);
        COUNTRYPOPULATION.put("Canada", 39476000);
        COUNTRYPOPULATION.put("Cocos [Keeling] Islands", 593);
        COUNTRYPOPULATION.put("DemocraticRepublicOfTheCongo", 95241000);
        COUNTRYPOPULATION.put("Central African Republic", 5368400);
        COUNTRYPOPULATION.put("Congo-Brazzaville", 5206400);
        COUNTRYPOPULATION.put("Switzerland", 8789700);
        COUNTRYPOPULATION.put("Coted'Ivoire", 29389000);
        COUNTRYPOPULATION.put("Cook Islands", 15250);
        COUNTRYPOPULATION.put("Chile", 19829000);
        COUNTRYPOPULATION.put("Cameroon", 24348000);
        COUNTRYPOPULATION.put("China", 1411750000);
        COUNTRYPOPULATION.put("HongKong", 7293200);
        COUNTRYPOPULATION.put("Macao", 671900);
        COUNTRYPOPULATION.put("Colombia", 51049000);
        COUNTRYPOPULATION.put("Costa Rica", 5111200);
        COUNTRYPOPULATION.put("Cuba", 11113000);
        COUNTRYPOPULATION.put("Cape Verde", 550480);
        COUNTRYPOPULATION.put("Christmas Island", 1692);
        COUNTRYPOPULATION.put("Cyprus", 875900);
        COUNTRYPOPULATION.put("CzechRepublic", 10527000);
        COUNTRYPOPULATION.put("Germany", 84271000);
        COUNTRYPOPULATION.put("Djibouti", 1078400);
        COUNTRYPOPULATION.put("Denmark", 5827500);
        COUNTRYPOPULATION.put("Dominica", 10536000);
        COUNTRYPOPULATION.put("Dominican Republic", 10536000);
        COUNTRYPOPULATION.put("Algeria", 45400000);
        COUNTRYPOPULATION.put("Ecuador", 18249000);
        COUNTRYPOPULATION.put("Estonia", 1328400);
        COUNTRYPOPULATION.put("Egypt", 104750000);
        COUNTRYPOPULATION.put("Western Sahara", 612200);
        COUNTRYPOPULATION.put("Eritrea", 5784500);
        COUNTRYPOPULATION.put("Spain", 47615000);
        COUNTRYPOPULATION.put("Ethiopia", 105160000);
        COUNTRYPOPULATION.put("Finland", 5526800);
        COUNTRYPOPULATION.put("Fiji", 895400);
        COUNTRYPOPULATION.put("Falkland Islands [Islas Malvinas]", 3662);
        COUNTRYPOPULATION.put("Micronesia", 105600);
        COUNTRYPOPULATION.put("Faroe Islands", 52199);
        COUNTRYPOPULATION.put("France", 68043000);
        COUNTRYPOPULATION.put("Gabon", 1906700);
        COUNTRYPOPULATION.put("UnitedKingdom", 67026000);
        COUNTRYPOPULATION.put("Scotland", 5422100);
        COUNTRYPOPULATION.put("Grenada", 108770);
        COUNTRYPOPULATION.put("Georgia", 3723500);
        COUNTRYPOPULATION.put("French Guiana", 301099);
        COUNTRYPOPULATION.put("Guernsey", 62792);
        COUNTRYPOPULATION.put("Ghana", 30832000);
        COUNTRYPOPULATION.put("Gibraltar", 32548);
        COUNTRYPOPULATION.put("Greenland", 56081);
        COUNTRYPOPULATION.put("Gambia", 2297700);
        COUNTRYPOPULATION.put("Guinea", 13262000);
        COUNTRYPOPULATION.put("Guadeloupe", 384239);
        COUNTRYPOPULATION.put("Equatorial Guinea", 1454800);
        COUNTRYPOPULATION.put("Greece", 10423000);
        COUNTRYPOPULATION.put("South Georgia and the South Sandwich Islands", 30);
        COUNTRYPOPULATION.put("Guatemala", 17358000);
        COUNTRYPOPULATION.put("Guam", 175200);
        COUNTRYPOPULATION.put("Guinea-Bissau", 1584800);
        COUNTRYPOPULATION.put("Guyana", 780200);
        COUNTRYPOPULATION.put("Gaza Strip", 2370000);
        COUNTRYPOPULATION.put("Hong Kong", 7293200);
        COUNTRYPOPULATION.put("Heard Island and McDonald Islands", 0);
        COUNTRYPOPULATION.put("Honduras", 9695900);
        COUNTRYPOPULATION.put("Croatia", 4076200);
        COUNTRYPOPULATION.put("Haiti", 11743000);
        COUNTRYPOPULATION.put("Hungary", 9678000);
        COUNTRYPOPULATION.put("Indonesia", 275770000);
        COUNTRYPOPULATION.put("Ireland", 4921500);
        COUNTRYPOPULATION.put("Israel", 9689100);
        COUNTRYPOPULATION.put("Isle of Man", 84069);
        COUNTRYPOPULATION.put("India", 1410200000);
        COUNTRYPOPULATION.put("British Indian Ocean Territory", 3500);
        COUNTRYPOPULATION.put("Iraq", 41191000);
        COUNTRYPOPULATION.put("Iran", 86239000);
        COUNTRYPOPULATION.put("Iceland", 364130);
        COUNTRYPOPULATION.put("Italy", 58886000);
        COUNTRYPOPULATION.put("Jersey", 106800);
        COUNTRYPOPULATION.put("Jamaica", 2726700);
        COUNTRYPOPULATION.put("Jordan", 11349000);
        COUNTRYPOPULATION.put("Japan", 124470000);
        COUNTRYPOPULATION.put("Kenya", 47564000);
        COUNTRYPOPULATION.put("Kyrgyzstan", 6523500);
        COUNTRYPOPULATION.put("Cambodia", 16524000);
        COUNTRYPOPULATION.put("Kiribati", 125000);
        COUNTRYPOPULATION.put("Comoros", 873720);
        COUNTRYPOPULATION.put("Saint Kitts and Nevis", 57567);
        COUNTRYPOPULATION.put("North Korea", 25660000);
        COUNTRYPOPULATION.put("SouthKorea", 51421000);
        COUNTRYPOPULATION.put("Kuwait", 4420100);
        COUNTRYPOPULATION.put("Cayman Islands", 68076);
        COUNTRYPOPULATION.put("Kazakhstan", 19788000);
        COUNTRYPOPULATION.put("Laos", 7013000);
        COUNTRYPOPULATION.put("Lebanon", 5490000);
        COUNTRYPOPULATION.put("Saint Lucia", 192190);
        COUNTRYPOPULATION.put("Liechtenstein", 38749);
        COUNTRYPOPULATION.put("Sri Lanka", 22181000);
        COUNTRYPOPULATION.put("Liberia", 4475400);
        COUNTRYPOPULATION.put("Lesotho", 2252600);
        COUNTRYPOPULATION.put("Lithuania", 2793500);
        COUNTRYPOPULATION.put("Luxembourg", 613890);
        COUNTRYPOPULATION.put("Latvia", 1906800);
        COUNTRYPOPULATION.put("Libya", 6281800);
        COUNTRYPOPULATION.put("Morocco", 36885000);
        COUNTRYPOPULATION.put("Monaco", 38300);
        COUNTRYPOPULATION.put("Moldova", 2681700);
        COUNTRYPOPULATION.put("Montenegro", 622360);
        COUNTRYPOPULATION.put("Madagascar", 28178000);
        COUNTRYPOPULATION.put("Marshall Islands", 55900);
        COUNTRYPOPULATION.put("Macedonia", 2077100);
        COUNTRYPOPULATION.put("Mali", 22594000);
        COUNTRYPOPULATION.put("Myanmar [Burma]", 55295000);
        COUNTRYPOPULATION.put("Mongolia", 3238400);
        COUNTRYPOPULATION.put("Macau", 671900);
        COUNTRYPOPULATION.put("Northern Mariana Islands", 56600);
        COUNTRYPOPULATION.put("Martinique", 364508);
        COUNTRYPOPULATION.put("Mauritania", 4077300);
        COUNTRYPOPULATION.put("Montserrat", 4400);
        COUNTRYPOPULATION.put("Malta", 493560);
        COUNTRYPOPULATION.put("Mauritius", 1221700);
        COUNTRYPOPULATION.put("Maldives", 374780);
        COUNTRYPOPULATION.put("Malawi", 17564000);
        COUNTRYPOPULATION.put("Mexico", 128860000);
        COUNTRYPOPULATION.put("Malaysia", 32693000);
        COUNTRYPOPULATION.put("Mozambique", 32420000);
        COUNTRYPOPULATION.put("Namibia", 2458900);
        COUNTRYPOPULATION.put("New Caledonia", 293600);
        COUNTRYPOPULATION.put("Niger", 24113000);
        COUNTRYPOPULATION.put("Norfolk Island", 2188);
        COUNTRYPOPULATION.put("Nigeria", 218540000);
        COUNTRYPOPULATION.put("Nicaragua", 6426100);
        COUNTRYPOPULATION.put("Netherlands", 17843000);
        COUNTRYPOPULATION.put("Norway", 5367600);
        COUNTRYPOPULATION.put("Nepal", 29192000);
        COUNTRYPOPULATION.put("Nauru", 11200);
        COUNTRYPOPULATION.put("Niue", 1520);
        COUNTRYPOPULATION.put("NewZealand", 4951500);
        COUNTRYPOPULATION.put("Oman", 4647500);
        COUNTRYPOPULATION.put("Panama", 4218800);
        COUNTRYPOPULATION.put("Peru", 33397000);
        COUNTRYPOPULATION.put("French Polynesia", 280600);
        COUNTRYPOPULATION.put("Papua New Guinea", 9123000);
        COUNTRYPOPULATION.put("Philippines", 110560000);
        COUNTRYPOPULATION.put("Pakistan", 235830000);
        COUNTRYPOPULATION.put("Poland", 37767000);
        COUNTRYPOPULATION.put("Saint Pierre and Miquelon", 5974);
        COUNTRYPOPULATION.put("Pitcairn Islands", 47);
        COUNTRYPOPULATION.put("Puerto Rico", 3193700);
        COUNTRYPOPULATION.put("Palestinian Territories", 4976700);
        COUNTRYPOPULATION.put("Portugal", 10345000);
        COUNTRYPOPULATION.put("Palau", 17900);
        COUNTRYPOPULATION.put("Paraguay", 7252700);
        COUNTRYPOPULATION.put("Qatar", 2747300);
        COUNTRYPOPULATION.put("Réunion", 873102);
        COUNTRYPOPULATION.put("Romania", 19054000);
        COUNTRYPOPULATION.put("Serbia", 6963800);
        COUNTRYPOPULATION.put("Yugoslavia", 20000000);
        COUNTRYPOPULATION.put("Russia", 146420000);
        COUNTRYPOPULATION.put("Rwanda", 13246000);
        COUNTRYPOPULATION.put("SaudiArabia", 34111000);
        COUNTRYPOPULATION.put("Solomon Islands", 714800);
        COUNTRYPOPULATION.put("Seychelles", 97625);
        COUNTRYPOPULATION.put("Sudan", 45202000);
        COUNTRYPOPULATION.put("Sweden", 10522000);
        COUNTRYPOPULATION.put("Singapore", 5703600);
        COUNTRYPOPULATION.put("Saint Helena", 5651);
        COUNTRYPOPULATION.put("Slovenia", 2094100);
        COUNTRYPOPULATION.put("Svalbard and Jan Mayen", 2939);
        COUNTRYPOPULATION.put("Slovakia", 5456400);
        COUNTRYPOPULATION.put("Sierra Leone", 7541600);
        COUNTRYPOPULATION.put("San Marino", 33574);
        COUNTRYPOPULATION.put("Senegal", 17739000);
        COUNTRYPOPULATION.put("Somalia", 17598000);
        COUNTRYPOPULATION.put("Suriname", 566390);
        COUNTRYPOPULATION.put("São Tomé and Príncipe", 214610);
        COUNTRYPOPULATION.put("El Salvador", 6210500);
        COUNTRYPOPULATION.put("Syria", 22125000);
        COUNTRYPOPULATION.put("Swaziland", 1377700);
        COUNTRYPOPULATION.put("Turks and Caicos Islands", 42953);
        COUNTRYPOPULATION.put("Chad", 16818000);
        COUNTRYPOPULATION.put("French Southern Territories", 0);
        COUNTRYPOPULATION.put("Togo", 7886000);
        COUNTRYPOPULATION.put("Thailand", 66215000);
        COUNTRYPOPULATION.put("Tajikistan", 9506000);
        COUNTRYPOPULATION.put("Tokelau", 1647);
        COUNTRYPOPULATION.put("Timor-Leste", 1387100);
        COUNTRYPOPULATION.put("Turkmenistan", 5706000);
        COUNTRYPOPULATION.put("Tunisia", 11804000);
        COUNTRYPOPULATION.put("Tonga", 100000);
        COUNTRYPOPULATION.put("Turkey", 85280000);
        COUNTRYPOPULATION.put("TrinidadTobago", 1364000);
        COUNTRYPOPULATION.put("Tuvalu", 10300);
        COUNTRYPOPULATION.put("Taiwan", 23333000);
        COUNTRYPOPULATION.put("Tanzania", 61741000);
        COUNTRYPOPULATION.put("Ukraine", 41130000);
        COUNTRYPOPULATION.put("Uganda", 42886000);
        COUNTRYPOPULATION.put("U.S. Minor Outlying Islands", 190);
        COUNTRYPOPULATION.put("UnitedStates", 334560000);
        COUNTRYPOPULATION.put("Uruguay", 3518600);
        COUNTRYPOPULATION.put("Uzbekistan", 36086000);
        COUNTRYPOPULATION.put("Vatican City", 825);
        COUNTRYPOPULATION.put("Saint Vincent and the Grenadines", 110610);
        COUNTRYPOPULATION.put("Venezuela", 28302000);
        COUNTRYPOPULATION.put("British Virgin Islands", 32543);
        COUNTRYPOPULATION.put("U.S. Virgin Islands", 106160);
        COUNTRYPOPULATION.put("Vietnam", 99460000);
        COUNTRYPOPULATION.put("Vanuatu", 319500);
        COUNTRYPOPULATION.put("Wallis and Futuna", 11600);
        COUNTRYPOPULATION.put("Samoa", 199853);
        COUNTRYPOPULATION.put("Kosovo", 1795700);
        COUNTRYPOPULATION.put("Yemen", 33697000);
        COUNTRYPOPULATION.put("Mayotte", 310022);
        COUNTRYPOPULATION.put("SouthAfrica", 60605000);
        COUNTRYPOPULATION.put("Zambia", 19611000);
        COUNTRYPOPULATION.put("Zimbabwe", 15179000);
        COUNTRYPOPULATION.put("Catalonia", 7522596);
    }
}
