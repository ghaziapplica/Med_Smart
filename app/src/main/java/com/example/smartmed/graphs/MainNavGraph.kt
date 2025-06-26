package com.example.smartmed.graphs

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.smartmed.AuthRouteScreen
import com.example.smartmed.Doctor.Doctor
import com.example.smartmed.Doctor.DoctorListScreen
import com.example.smartmed.Doctor.FindDoctor
import com.example.smartmed.FindServiceScreen
import com.example.smartmed.Graph
import com.example.smartmed.MainRouteScreen
import com.example.smartmed.Pharmacy.PharmacyListScreen
import com.example.smartmed.bottomBarScreens.HomeScreen
import com.example.smartmed.chatBot.ChatRepository
import com.example.smartmed.chatBot.ChatScreen
import com.example.smartmed.chatBot.ChatViewModel
import com.example.smartmed.homeScreen.ChatHistoryScreen
import com.example.smartmed.homeScreen.FavoriteScreen
import com.example.smartmed.Pharmacy.pharmaciesList
import com.example.smartmed.ProfileSharedViewModel
import com.example.smartmed.authScreen.LoginScreen
import com.example.smartmed.authScreen.ProfileScreen
import com.example.smartmed.authScreen.ProfileViewModel
import com.example.smartmed.components.FavoriteTipsScreen
import com.example.smartmed.components.HealthTipsViewModel
import com.example.smartmed.homeScreen.EditProfileScreen
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainNavGraph(
    rootNavController: NavHostController,
    homeNavController: NavHostController,
    innerPadding: PaddingValues,
    profileSharedViewModel: ProfileSharedViewModel
) {
    val healthTipsViewModel: HealthTipsViewModel = viewModel()

    NavHost(
        navController = homeNavController,
        route = Graph.MainScreenGraph,
        startDestination = MainRouteScreen.HomeScreen.route
    ) {

        composable(route = MainRouteScreen.HomeScreen.route) {
            HomeScreen(innerPadding = innerPadding,
                navController = homeNavController,
                profileSharedViewModel = profileSharedViewModel,
                healthTipsViewModel = healthTipsViewModel)
        }
        composable(route = MainRouteScreen.FindScreen.route) {
            FindServiceScreen(
                navController = homeNavController,
                innerPadding = innerPadding)
        }
        composable(route = MainRouteScreen.HeartScreen.route) {
            FavoriteTipsScreen(innerPadding = innerPadding,
                viewModel = healthTipsViewModel     )
        }
        composable(route = MainRouteScreen.MyProfileScreen.route) {
            EditProfileScreen(innerPadding = innerPadding,profileSharedViewModel = profileSharedViewModel,
                navController = homeNavController)
        }
        composable(route = MainRouteScreen.AiScreen.route) {
            ChatScreen(
                viewModel = ChatViewModel(ChatRepository()),
                innerPadding = innerPadding,
                navController = homeNavController
            )
        }
        composable("login_screen") {
            LoginScreen(
                navController = homeNavController,
                    loginViewModel = viewModel(),
            )
        }

        composable("specialist_selection") {
            FindDoctor(navController = homeNavController)
        }
        composable("pharmacy_selection") {
            PharmacyListScreen(navController = homeNavController,
                        pharmacies = pharmaciesList,
                )
        }
        composable("chatbot_selection") {
            ChatScreen( viewModel = ChatViewModel(ChatRepository()),
                innerPadding = innerPadding,
                navController = homeNavController
                )
        }
//        composable(Screen.HomeNotes.route){
//            HomeView(
//                navController = homeNavController,
//                viewModel = viewModel()
//            )
//        }






        composable("doctor_list_screen/{category}") { backStackEntry ->
            val categoryEncoded = backStackEntry.arguments?.getString("category") ?: ""
            val category = URLDecoder.decode(categoryEncoded, StandardCharsets.UTF_8.name())
            val doctors = when (category) {
                "Heart Specialist (Cardiologist)" -> listOf(
                    Doctor("Dr. Muhammad Ashfaq", "Heart Center Clinic (Dr. Ashfaq), Jail Road, Lahore", "042-38900939", "https://www.pakistanfreeads.com/wp-content/uploads/2021/03/d237.png", "Clinic open 24/7; Dr. Ashfaq consults by appointment (typically evenings)", "Mon-Sun, 12:00 AM - 11:59 PM"),
                    Doctor("Dr. Amanullah", "12-Ghous-ul-Azam Road, Shadman II, Lahore", "0333-4223358 ","https://www.pakistanfreeads.com/wp-content/uploads/2021/03/d80.png", "Mon–Sat, 6:00 PM – 9:00 PM (evening clinic)" , "Mon-Sat, 6:00 AM - 9:00 P   M"),
                    Doctor("Dr. Javaid Sabzwari", "House #19-E/1, Valencia Town, Lahore", "0333-4227772","https://www.pakistanfreeads.com/wp-content/uploads/2021/03/d241.png", "Mon–Sat, 6:00 PM – 9:00 PM (evening clinic)", "Mon-Sat, 6:00 AM - 9:00 PM" ),
                    Doctor("Dr. Mirza Nadeem Baig", "Main Sharaqpur Road (near Shahdara), Lahore ", "0334-5674949", "https://www.pakistanfreeads.com/wp-content/uploads/2021/03/d242.png", "Mon–Sat, 5:00 PM – 9:00 PM (clinic in the evenings)", "Mon-Sat, 5:00 PM - 9:00 PM"  ),
                    Doctor("Assoc. Prof. Dr. Nasir Iqbal", "5-Race Course Road (Dr. Ijaz Clinic), GOR-I, Lahore", "(042) 32591427","https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg" , "Mon-Fri, 6:00 PM - 9:00 PM at Latif Hospital; other days by appointment at Dr. Ijaz Clinic.", "Mon-Fri, 6:00 PM - 9:00 PM")
                )
                "Skin Specialist (Dermatologist)" -> listOf(
                    Doctor("Dr. Zarqa Suharwardy Taimur", "14-B/1, FCC, Syed Maratib Ali Road (near FC College), Gulberg IV, Lahore", "042-35694061 / 042-35694062","https://www.pakistanfreeads.com/wp-content/uploads/2023/07/download-2.jpg", "Mon–Sat, 1:00 PM – 10:00 PM (multiple branches; Gulberg clinic hours)" , "Mon–Sat, 1:00 PM – 10:00 PM"),
                    Doctor("Dr. Sania Javaid", "Plaza C-134, Sector Y, Phase 3, DHA, Lahore","0320-4800368","https://www.pakistanfreeads.com/wp-content/uploads/2023/07/dr-rabia-ishfaq-dermatologist-lahore-68_450X450-2.jpeg", "Mon–Sat, 1:00 PM – 10:00 PM", "Mon–Sat, 1:00 PM - 10:00 PM"),
                    Doctor("Prof. Dr. Azim Jahangir Khan", "445-G4, Main Boulevard, Johar Town (near Khokhar Chowk), Lahore", "03-111-077-111","https://www.pakistanfreeads.com/wp-content/uploads/2023/07/download-8-3.jpg", "Mon–Sat, by appointment (clinic with multiple cosmetic dermatology services).", "Mon–Sat, 1:00 PM – 10:00 PM"),
                    Doctor("Dr. Farah Aamir", "42-A, Block B-II, Ghalib Road, Gulberg III, Lahore", "042-35771133 / 042-35771144 / 0300-9458585","https://www.pakistanfreeads.com/wp-content/uploads/2023/07/dr-hina-manzoor-dermatologist-lahore-45_450X450-2.jpg", "Mon–Fri 11:00 AM – 5:00 PM; Saturday 11:00 AM – 5:00 PM (closed Sunday)." , "Mon–Sat, 11:00 AM – 5:00 PM"),
                    Doctor("Dr. Tahir Kamal", "Link-2, Street 1, 26-C Cavalry Ground, Lahore (near CSD)", "042-36602500 / 042-36120220", "https://www.pakistanfreeads.com/wp-content/uploads/2023/07/assoc-prof-dr-uzma-saleem-dermatologist-lahore-51_450X450-2.jpg", "Mon–Sat, 7:00 PM – 10:00 PM (evening clinic hours).", "Mon–Sat, 7:00 PM – 10:00 PM")
                )
                "Child Specialist (Pediatrician)" -> listOf(
                    Doctor("Prof. Dr. Humayun Iqbal Khan", "761 Block G4, Phase 2, Johar Town, Lahore", "0324-4211214","https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg", "Mon–Sat, morning and evening sessions by appointment.", "Mon–Sat, 7:00 PM – 10:00 PM" ),
                    Doctor("Assoc. Prof. Dr. Hassan Suleman Malik", "49-Aibak Block (near Barkat Market), New Garden Town, Lahore","0341-2017777","https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg" ,"Clinic open 24/7; Dr. Malik consults in the evenings (appointment via helpline)", "Mon-Sun, 12:00 AM - 11:59 PM"  ),
                    Doctor("Dr. Shahid Hameed", "Maulana Shaukat Ali Road (opposite Johar Banquet, near Ferozepur Rd/Faisal Town), Lahore","Available via clinic reception, no direct line listed", "https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg" , "Mon–Sat, 6:00 PM – 9:00 PM (evening clinic)", "Mon–Sat, 6:00 PM – 9:00 PM" ),
                    Doctor("Prof. Dr. Tariq Rafiq Khan", "Civic Center, Faisal Town, Lahore (near Faisal Town roundabout)", "042-3516XXXX (via Doctors Hospital or clinic reception)", "https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg", "Mon–Thu & Sat, 5:00 PM – 8:00 PM at private clinic; also available at Doctors Hospital (Johar Town) mornings", "Mon–Sat, 5:00 PM – 8:00 PM"),
                    Doctor("Dr. Muhammad Asif Sheikh", "35-Shalimar Link Road, Mughalpura, Lahore", "(042) 35220611","https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg" ,"Mon–Sat, 5:00 PM – 9:00 PM (pediatric consultations; clinic has 24/7 emergency)", "Mon–Sat, 5:00 PM – 9:00 PM" )
                )
                "Eye Specialist (Ophthalmologist)" -> listOf(
                    Doctor("Dr. A. Khawaja", "06-A Aurangzeb Block, New Garden Town, Lahore","(042) 3588XXXX",  "https://www.pakistanfreeads.com/wp-content/uploads/2020/10/doctor-36-1.png", "5:00 PM – 9:00 PM, Monday through Saturday (evening clinic)",  "Mon–Sat, 5:00 PM – 9:00 PM"),
                    Doctor("Prof. Dr. Suhail Sarwar", "2nd Floor, 54-MB, Phase 6, DHA, Lahore", "0300-4721112","https://www.pakistanfreeads.com/wp-content/uploads/2021/03/d96.png" , "Mon–Fri 3:00 PM – 7:00 PM (consultations by appointment at private eye hospital)", "Mon–Fri, 3:00 PM – 7:00 PM"),
                    Doctor("Dr. Syed Raza Ali Shah", "Ali Retina Eye Clinic, DHA Phase 1, Lahore (near Ghazi Rd)", "0300-9463804", "https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg", "Clinic operational 1:00 PM – 11:00 PM, Monday to Saturday", "Mon–Sat, 1:00 PM – 11:00 PM"),
                    Doctor("Yaqin Vision Eye Centre", "37-Shadman Colony I, Shadman, Lahore", "(042) 37577701", "https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg", "Mon–Sat, 3:00 PM – 8:00 PM (closed Sunday)", "Mon–Sat, 3:00 PM – 8:00 PM"),
                    Doctor("Al-Noor Eye Centre", "16-B, PCSIR Phase II, Nazaria-e-Pakistan Ave, Lahore", "0300-8454810","https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg", "Mon–Sat, 10:00 AM – 6:00 PM (advanced eye care facility, by appointment)", "Mon–Sat, 10:00 AM – 6:00 PM" )
                )
                "Psychiatrist" -> listOf(
                    Doctor("Dr. Sumira K. Bukhari", "2-Shahrah Aiwan-e-Sanat-o-Tijarat, GOR-I, Lahore", "(042) 32500989 ", "https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg", "Mon–Sat evenings by appointment (Kanan Clinic is 24/7, doctor’s OPD 5:00 PM – 9:00 PM)", "Mon–Sat, 5:00 PM – 9:00 PM"),
                    Doctor("Dr. Abdul Haleem", "House #53, Street 5, Sultan Town (adjacent to Al-Noor Garden, near UOL Raiwind Rd), Lahore", "0302-2788999 / 0331-8970787", "https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg", "Clinic open 24/7; Dr.Dr.Haleem sees patients by appointment (typically afternoons and evenings", "Mon-Sun, 12:00 AM - 11:59 PM"),
                    Doctor("Dr. Aneel Shafi", "Plot #117, Block B, Bankers Town, Kamahan (Dhalla) Road Roundabout, Lahore", "042-3XXXXXXX (clinic landline)","https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg", "Tuesdays 5:00 PM – 6:00 PM at Health Street Clinic (other days via video or at hospital clinic)", "Tues, 5:00 PM – 6:00 PM" ),
                    Doctor("Prof. Dr. Imran Ijaz Haider", "5-Race Course Road, G.O.R.-I, Lahore", " 0317-1777509","https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg"," Mon, Wed, Fri 7:00 PM – 9:00 PM at Ijaz Clinic; also consults at Fatima Memorial Hosp in mornings", "Mon, Wed, Fri, 7:00 PM – 9:00 PM" ),
                    Doctor("Dr. S. K. Rais", "CMH Lahore (Outdoor Psychiatry Clinic) on Sarwar Road, Lahore Cantt", "(042) 366XXX or via CMH operator","https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg", "Mon–Fri, 8:00 AM – 2:00 PM (hospital OPD); limited private evening slots by prior arrangement.", "Mon–Fri, 8:00 AM – 2:00 PM" )
                )
                "Orthopedic Surgeon" -> listOf(
                    Doctor("Prof. Dr. Amir Aziz", "G.T. Road, near Jallo Morr, Lahore", "(042) 111-348-348","https://www.pakistanfreeads.com/wp-content/uploads/2021/03/d21.png", " Mon–Thu mornings at Ghurki Hospital (Spine OPD); limited evening clinic weekly by appointment", "Mon–Thu, 8:00 AM – 1:00 PM" ),
                    Doctor("Dr. Atiq uz Zaman", "Ghurki Hospital, G.T. Road, Lahore (morning OPD) / Beacon House Society, Defence Road", "(042) 37902701", "https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg", "Ghurki Hospital Mon–Sat 8:00 AM – 1:00 PM Private clinic in evenings by appointment.", "Mon–Sat, 8:00 AM – 1:00 PM"),
                    Doctor("Dr. Muhammad Bilal Raza", "Faisal Hospital, Gulberg (Nazim-ud-Din Rd) ","042-111-000-043", "https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg", "Mon–Sat, 5:00 PM – 8:00 PM at Faisal Hospital (Orthopedic OPD)", "Mon–Sat, 5:00 PM – 8:00 PM" ),
                    Doctor("Dr. Abdullah Shah", "Ghurki Hospital (daytime) and MedCare Clinic, Johar Town (evening)", "0300-9400XXX (for Johar Town clinic appointments)",  "https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg", " Tue & Thu 7:00 PM – 9:00 PM at Johar Town clinic; other days at Ghurki Hospital", "Tues & Thurs, 7:00 PM – 9:00 PM"),
                    Doctor("Dr. Rana Dilawaz Khan", "Services Hospital Orthopedic OPD (Shadman) and Rana Clinic, E/2 Model Town, Lahore", "(042) 99203402","https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg" , " Services Hosp in mornings; Model Town clinic Mon/Wed/Fri 6:00 PM – 9:00 PM.", "Mon/Wed/Fri 6:00 PM – 9:00 PM")
                )
                "Gynecologist" -> listOf(
                    Doctor("Prof. Dr. Khadija Khan", "Hameed Latif Hospital, 14-Abubakar Block, New Garden Town, Lahore", "(042) 111-000-043", "https://www.pakistanfreeads.com/wp-content/uploads/2021/03/d104.png", "Mon–Fri 10:00 AM – 2:00 PM (Hospital OPD); limited evening clinic by appointment.", "Mon–Fri, 10:00 AM – 2:00 PM;"),
                    Doctor("Prof. Col. (Retd.) Dr. Nazli Hameed", "-Sarfraz Rafiqui Road, Lahore Cantt (near CMH)", "042-3668XXXX (clinic)", "https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg", "vMon–Thu 12:00 PM – 3:00 PM at Cantt clinic (prior appointment required)", "Mon–Thu, 12:00 PM – 3:00 PM"),
                    Doctor("Assist. Prof. Dr. Kiran Iqbal", "Doctors Hospital & Medical Center, 152-G/1 Canal Bank, Johar Town, Lahore", "(042) 35302701-14","https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg", "Mon/Wed/Fri 5:00 PM – 8:00 PM at Doctors Hospital; other days via online consult", "Mon, Wed, Fri, 5:00 PM – 8:00 PM" ),
                    Doctor("Dr. Mariam Iqbal", "5-A Model Town Extension, Lahore (near Husnain Medical Complex)", "0300-940XXXX", "https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg", "Tue, Thu, Sat 6:00 PM – 9:00 PM (private clinic); also consultant at Mukhtar Memorial Hospital in mornings.", "Tues, Thurs, Sat, 6:00 PM – 9:00 PM"),
                    Doctor("Prof. Dr. Ambreen Akhtar", "11-Km Ahmed Ali Road, Johar Town, Lahore (Horizon Hospital)", "(042) 35401620","https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg" , "Mon–Sat 2:00 PM – 6:00 PM at Horizon Hospital (advanced gynae surgeries and OPD)", "Mon–Sat, 2:00 PM – 6:00 PM")
                )
                "Dentist" -> listOf(
                    Doctor("Dr. Irfan Qureshi", "13-E, Block H, College Road (opposite Sukh Chan Club), Gulberg II, Lahore", "042-35761414 / 0308-4441414","https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg", "Mon–Sat 9:00 AM – 5:00 PM (state-of-the-art multi-dentist clinic)", "Mon–Sat, 9:00 AM – 5:00 PM" ),
                    Doctor("Dr. Abdul Sami Chaudhary", "66-M, Gulberg II, Lahore (near Mini Market).", "042-357858XX", "https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg", "Mon–Sat, 12:00 PM – 8:00 PM (general and cosmetic dentistry)", "Mon–Sat, 12:00 PM – 8:00 PM"),
                    Doctor("Dr. Sara Malik", "57-C/1, MM Alam Road, Gulberg III, Lahore", "042-3587XXXX","https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg", "Mon–Fri 2:00 PM – 8:00 PM (laser dentistry, cosmetic dental procedures)", "Mon–Fri, 2:00 PM – 8:00 PM" ),
                    Doctor("Dr. Zeeshan Farooq", "13-CC, Commercial Area, Phase IV, DHA, Lahore", "0300-8788867","https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg","Mon–Sat 11:00 AM – 7:00 PM (advanced implantology and orthodontics services)", "Mon–Sat, 11:00 AM – 7:00 PM" ),
                    Doctor("Dr. Fariha Khan", "101-P, Block P, Gulberg III (near Ferozepur Road & Kalma Chowk), Lahore", "042-3586XXXX","https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg", "Mon–Sat 10:00 AM – 5:00 PM (family and pediatric dentistry)" , "Mon–Sat, 10:00 AM – 5:00 PM")
                )
                else -> emptyList()
            }
            DoctorListScreen(doctors = doctors, navController = homeNavController, category = category)

        }

    }
}
