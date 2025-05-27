import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import coil.compose.rememberAsyncImagePainter
import com.example.smartmed.R
import com.example.smartmed.ui.theme.poppinsFamilyFont
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DoctorPopupDialog(onDismiss: () -> Unit,
                      category: String,
                      doctorName: String,
                      contactNumber: String?,
                      profileImageUrl: String,
                      availability : String,
                      address : String

                      ) {

    Dialog(onDismissRequest = onDismiss) {
        Box(
            modifier = Modifier
                .size(width = 308.dp, height = 510.dp)
                .border(
                    width = 7.dp,
                    color = Color(0xFF0077B6),
                    shape = RoundedCornerShape(11.dp)
                )
                .padding(2.dp) // Add padding to separate border from content
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White, shape = RoundedCornerShape(8.dp))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.close), // replace with your drawable
                    contentDescription = "Clickable Icon",
                    modifier = Modifier
                        .size(40.dp)
                        .align(Alignment.TopEnd) // ✅ this puts it top right
                        .clickable {
                            onDismiss()
                        }
                )

            }
            Spacer(modifier = Modifier.height(18.dp))
            Column (
                modifier = Modifier.fillMaxSize()
                    .padding(top = 30.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                ){
                Image(
                    painter = rememberAsyncImagePainter(profileImageUrl),
                    contentDescription = "Doctor Profile Image",
                    modifier = Modifier
                        .size(76.dp)
                        .clip(androidx.compose.foundation.shape.CircleShape) // ✅ Ensures image stays circular
                        .border(
                            width = 4.dp,
                            color = Color(0xFF0077B6),
                            shape = androidx.compose.foundation.shape.CircleShape
                        )
                        .clickable { }
                )

                Spacer(modifier = Modifier.height(22.dp))
                Box (
                    modifier = Modifier.align(Alignment.CenterHorizontally)

                ) {

                    Text(
                        text = doctorName,
                        modifier = Modifier.align(Alignment.CenterStart)
                            .padding(horizontal = 16.dp),
                        fontFamily = poppinsFamilyFont,
                        color = Color(0xFF0077B6),
                        fontWeight = FontWeight.Normal,
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center

                    )
                }

                Text(
                    text = category,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontFamily = poppinsFamilyFont,
                    color = Color(0xFF979797),
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(28.dp))
                Box(
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                        .fillMaxWidth()
                ){

                    Text(
                        text = address,
                        modifier = Modifier.padding(horizontal = 16.dp),
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = Color.DarkGray,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center

                        )
                    )
                }
                Spacer(modifier = Modifier.height(18.dp))

                Divider(
                    color = Color(0x380077B6), // This is #0077B638
                    modifier = Modifier
                        .width(311.dp)
                        .height(1.dp)
                )
                Spacer(modifier = Modifier.height(18.dp))
                Text(
                    text =
                        "Contact Number: $contactNumber",
                    modifier = Modifier.padding(horizontal = 16.dp)
                        .align(Alignment.CenterHorizontally),
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = Color.DarkGray,
                        fontSize = 14.sp
                    ),
                )




                Spacer(modifier = Modifier.height(16.dp))

                Divider(
                    color = Color(0x380077B6), // This is #0077B638
                    modifier = Modifier
                        .width(311.dp)
                        .height(1.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))
                Column (
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                        .fillMaxWidth()


                ){
                    Text(
                        text = "Availability",
                        modifier = Modifier.padding(horizontal = 16.dp)
                            .align(Alignment.CenterHorizontally),
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = Color.DarkGray,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,


                        ),
                        )
                    Spacer(modifier = Modifier.height(18.dp))
                        Text(
                            text = availability,
                            modifier = Modifier.padding(horizontal = 36.dp)
                                .align(Alignment.CenterHorizontally),
                            style = MaterialTheme.typography.bodySmall.copy(
                                color = Color.DarkGray,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Center


                            ),
                    )
                }


            }
        }

    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview
fun DoctorPopupDialogPreview() {
    DoctorPopupDialog(onDismiss = {}, category = "Heart Specialist (Cardiologist)",
        doctorName = "Dr. John Doe",
        contactNumber = "123-456-7890",
        profileImageUrl = "",
        availability = "gtrgggttrbrtrg",
        address = "djeuiwpfyhiwop fhwuiof ywpfywp fyhw2789yu0e")
}
