package com.example.smartmed.Doctor

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "doctors")
data class DoctorEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val profileImageUrl: String,       // 🆕 for image URL
    val contactNumber: String?          // 🆕 for contact number

)


val doctors = listOf(
    DoctorEntity(
        profileImageUrl = "https://www.pakistanfreeads.com/wp-content/uploads/2021/03/d237.png",
        contactNumber = "042-38900939"
    ),
    DoctorEntity(
        profileImageUrl = "https://www.pakistanfreeads.com/wp-content/uploads/2021/03/d80.png",
        contactNumber = "0333-4223358 "
    ),
    DoctorEntity(
        profileImageUrl = "https://www.pakistanfreeads.com/wp-content/uploads/2021/03/d241.png",
        contactNumber = "0333-4227772"
    ),
    DoctorEntity(
        profileImageUrl = "https://www.pakistanfreeads.com/wp-content/uploads/2021/03/d242.png",
        contactNumber = "0334-5674949"
    ),
    DoctorEntity(
        profileImageUrl = "https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg",
        contactNumber = "(042) 32591427"
    ),
    DoctorEntity(
        profileImageUrl = "https://www.pakistanfreeads.com/wp-content/uploads/2023/07/download-2.jpg",
        contactNumber = "042-35694061 / 042-35694062"
    ),
    DoctorEntity(
        profileImageUrl = "https://www.pakistanfreeads.com/wp-content/uploads/2023/07/dr-rabia-ishfaq-dermatologist-lahore-68_450X450-2.jpeg",
        contactNumber = "0320-4800368"
    ),
    DoctorEntity(
        profileImageUrl = "https://www.pakistanfreeads.com/wp-content/uploads/2023/07/download-8-3.jpg",
        contactNumber = "03-111-077-111"
    ),
    DoctorEntity(
        profileImageUrl = "https://www.pakistanfreeads.com/wp-content/uploads/2023/07/dr-hina-manzoor-dermatologist-lahore-45_450X450-2.jpg",
        contactNumber = "042-35771133 / 042-35771144 / 0300-9458585"
    ),
    DoctorEntity(
        profileImageUrl = "https://www.pakistanfreeads.com/wp-content/uploads/2023/07/assoc-prof-dr-uzma-saleem-dermatologist-lahore-51_450X450-2.jpg",
        contactNumber = "042-36602500 / 042-36120220"
    ),
    DoctorEntity(
        profileImageUrl = "https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg",
        contactNumber = "0324-4211214"
    ),
    DoctorEntity(
        profileImageUrl = "https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg",
        contactNumber = "0341-2017777"
    ),
    DoctorEntity(
        profileImageUrl = "https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg",
        contactNumber = "Available via clinic reception, no direct line listed"
    ),
    DoctorEntity(
        profileImageUrl = "https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg",
        contactNumber = "042-3516XXXX (via Doctors Hospital or clinic reception)"
    ),
    DoctorEntity(
        profileImageUrl = "https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg",
        contactNumber = "(042) 35220611"
    ),
    DoctorEntity(
        profileImageUrl = "https://www.pakistanfreeads.com/wp-content/uploads/2020/10/doctor-36-1.png",
        contactNumber = "(042) 3588XXXX"
    ),
    DoctorEntity(
        profileImageUrl = "https://www.pakistanfreeads.com/wp-content/uploads/2021/03/d96.png",
        contactNumber = "0300-4721112"
    ),
    DoctorEntity(
        profileImageUrl = "https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg",
        contactNumber = "0300-9463804"
    ),
    DoctorEntity(
        profileImageUrl = "https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg",
        contactNumber = "(042) 37577701"
    ),
    DoctorEntity(
        profileImageUrl = "https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg",
        contactNumber = "0300-8454810"
    ),
    DoctorEntity(
        profileImageUrl = "https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg",
        contactNumber = "(042) 32500989 "
    ),
    DoctorEntity(
        profileImageUrl = "https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg",
        contactNumber = "0302-2788999 / 0331-8970787"
    ),
    DoctorEntity(
        profileImageUrl = "https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg",
        contactNumber = "042-3XXXXXXX (clinic landline)"
    ),
    DoctorEntity(
        profileImageUrl = "https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg",
        contactNumber = " 0317-1777509"
    ),
    DoctorEntity(
        profileImageUrl = "https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg",
        contactNumber = "(042) 366XXX or via CMH operator"
    ),
    DoctorEntity(
        profileImageUrl = "https://www.pakistanfreeads.com/wp-content/uploads/2021/03/d21.png",
        contactNumber = "(042) 111-348-348"
    ),
    DoctorEntity(
        profileImageUrl = "https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg",
        contactNumber = "(042) 37902701"
    ),
    DoctorEntity(
        profileImageUrl = "https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg",
        contactNumber = "042-111-000-043"
    ),
    DoctorEntity(
        profileImageUrl = "https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg",
        contactNumber = "0300-9400XXX (for Johar Town clinic appointments)"
    ),
    DoctorEntity(
        profileImageUrl = "https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg",
        contactNumber = "(042) 99203402"
    ),
    DoctorEntity(
        profileImageUrl = "https://www.pakistanfreeads.com/wp-content/uploads/2021/03/d104.png",
        contactNumber = "(042) 111-000-043"
    ),
    DoctorEntity(
        profileImageUrl = "https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg",
        contactNumber = "042-3668XXXX (clinic)"
    ),
    DoctorEntity(
        profileImageUrl = "https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg",
        contactNumber = ": (042) 35302701-14"
    ),
    DoctorEntity(
        profileImageUrl = "https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg",
        contactNumber = "0300-940XXXX"
    ),
    DoctorEntity(
        profileImageUrl = "https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg",
        contactNumber = "(042) 35401620"
    ),
    DoctorEntity(
        profileImageUrl = "https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg",
        contactNumber = "042-35761414 / 0308-4441414"
    ),
    DoctorEntity(
        profileImageUrl = "https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg",
        contactNumber = "042-357858XX"
    ),
    DoctorEntity(
        profileImageUrl = "https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg",
        contactNumber = "042-3587XXXX"
    ),
    DoctorEntity(
        profileImageUrl = "https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg",
        contactNumber = "0300-8788867"
    ),
    DoctorEntity(
        profileImageUrl = "https://static.vecteezy.com/system/resources/previews/021/548/095/original/default-profile-picture-avatar-user-avatar-icon-person-icon-head-icon-profile-picture-icons-default-anonymous-user-male-and-female-businessman-photo-placeholder-social-network-avatar-portrait-free-vector.jpg",
        contactNumber = "042-3586XXXX"
    ),


)
